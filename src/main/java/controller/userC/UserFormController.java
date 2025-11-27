package controller.userC;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.Setter;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;
import service.UserService;
import service.impl.UserServiceImpl;

@Setter
public class UserFormController {

    private final UserService userService = new UserServiceImpl();
    private UserController parentController;

    @FXML private TextField txtUserId, txtFirstName, txtLastName, txtUserName, txtPassword, txtConfirmpassword;
    @FXML private ComboBox<Roles> cbRole;
    @FXML private ComboBox<Status> cbStatus;
    @FXML private Button btnAddNew, btnEdit, btnDelete, btnClear, btnBack;

    public void initialize() {
        cbRole.setItems(FXCollections.observableArrayList(Roles.values()));
        cbStatus.setItems(FXCollections.observableArrayList(Status.values()));

        btnAddNew.setDisable(false);
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
    }

    public void setNewUserId(String id) {
        txtUserId.setText(id);
    }

    public void setUserData(UserDTO user) {
        txtUserId.setText(user.getId());
        txtFirstName.setText(user.getFirstName());
        txtLastName.setText(user.getLastName());
        txtUserName.setText(user.getUserName());
        txtPassword.setText(user.getPassword());
        txtConfirmpassword.setText(user.getPassword());
        cbRole.setValue(user.getRole());
        cbStatus.setValue(user.getStatus());

        btnAddNew.setDisable(true);
        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (!validateFields()) return;

        UserDTO user = new UserDTO(
                txtUserId.getText(), txtFirstName.getText(), txtLastName.getText(),
                txtUserName.getText(), txtPassword.getText(), cbRole.getValue(),
                cbStatus.getValue(), null, null
        );

        UserDTO saved = userService.createUser(user);
        if (saved != null) {
            if (parentController != null) parentController.loadUserTable();
            closeWindow();
        }
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {
        if (!validateFields()) return;

        UserDTO user = new UserDTO(
                txtUserId.getText(), txtFirstName.getText(), txtLastName.getText(),
                txtUserName.getText(), txtPassword.getText(), cbRole.getValue(),
                cbStatus.getValue(), null, null
        );

        userService.updateUser(user);
        if (parentController != null) parentController.loadUserTable();
        closeWindow();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String userId = txtUserId.getText();
        if (userId == null || userId.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "No user selected for deletion!").show();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Delete Confirmation");
        confirm.setHeaderText("Are you sure you want to delete this user?");
        confirm.setContentText("User ID: " + userId);

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                boolean deleted = userService.deleteUser(userId);
                if (deleted) {
                    new Alert(Alert.AlertType.INFORMATION, "User deleted successfully!").show();
                    if (parentController != null) parentController.loadUserTable();
                    closeWindow();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to delete user!").show();
                }
            }
        });
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUserId.clear(); txtFirstName.clear(); txtLastName.clear();
        txtUserName.clear(); txtPassword.clear(); txtConfirmpassword.clear();
        cbRole.getSelectionModel().clearSelection(); cbStatus.getSelectionModel().clearSelection();
        btnAddNew.setDisable(false); btnEdit.setDisable(true); btnDelete.setDisable(true);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    private boolean validateFields() {
        if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty() ||
                txtConfirmpassword.getText().isEmpty() || cbRole.getValue() == null ||
                cbStatus.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Please fill all fields!").show();
            return false;
        }

        if (!txtPassword.getText().equals(txtConfirmpassword.getText())) {
            new Alert(Alert.AlertType.WARNING, "Passwords do not match!").show();
            return false;
        }
        return true;
    }
}
