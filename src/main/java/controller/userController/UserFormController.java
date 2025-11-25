package controller.userController;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;
import service.UserService;
import service.impl.UserServiceImpl;

import java.util.Optional;

public class UserFormController {

    private final UserService userService = new UserServiceImpl();
    private UserController parentController;

    @FXML
    private Button btnAddNew;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnClear;

    @FXML
    private ComboBox<Roles> cbRole;

    @FXML
    private ComboBox<Status> cbStatus;

    @FXML
    private TextField txtConfirmpassword;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;


    public void initialize() {
        cbRole.setItems(FXCollections.observableArrayList(Roles.values()));
        cbStatus.setItems(FXCollections.observableArrayList(Status.values()));

        // Default mode = Add new
        btnAddNew.setDisable(false);
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
    }


    // For new user mode
    public void setNewUserId(String id) {
        txtUserId.setText(id);
    }

    // Save (Add new)
    @FXML
    void btnAddOnAction(ActionEvent event) {
        try {
            if (!validateFields()) return;

            UserDTO newUser = new UserDTO();
            newUser.setId(txtUserId.getText());
            newUser.setFirstName(txtFirstName.getText());
            newUser.setLastName(txtLastName.getText());
            newUser.setUserName(txtUserName.getText());
            newUser.setPassword(txtPassword.getText());
            newUser.setRole(cbRole.getValue());
            newUser.setStatus(cbStatus.getValue());

            UserDTO savedUser = userService.createUser(newUser);

            if (savedUser != null) {
                if (parentController != null) {
                    parentController.loadUserTable(); // refresh table
                }
                clearForm();
                ((Stage) btnAddNew.getScene().getWindow()).close(); // auto close
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Back button
    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {
        try {
            if (!validateFields()) return;

            UserDTO updatedUser = new UserDTO();
            updatedUser.setId(txtUserId.getText());
            updatedUser.setFirstName(txtFirstName.getText());
            updatedUser.setLastName(txtLastName.getText());
            updatedUser.setUserName(txtUserName.getText());
            updatedUser.setPassword(txtPassword.getText());
            updatedUser.setRole(cbRole.getValue());
            updatedUser.setStatus(cbStatus.getValue());

            userService.updateUser(updatedUser);
            System.out.println("User updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void btnClearOnAction(ActionEvent event) {
        clearForm();
    }

    private void clearForm() {
        txtUserId.clear();
        txtFirstName.clear();
        txtLastName.clear();
        txtUserName.clear();
        txtPassword.clear();
        txtConfirmpassword.clear();
        cbRole.getSelectionModel().clearSelection();
        cbStatus.getSelectionModel().clearSelection();

        // Reset to Add mode
        btnAddNew.setDisable(false);
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
    }

    private boolean validateFields() {
        if (txtFirstName.getText().isEmpty() ||
                txtLastName.getText().isEmpty() ||
                txtUserName.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
                txtConfirmpassword.getText().isEmpty() ||
                cbRole.getValue() == null ||
                cbStatus.getValue() == null) {

            System.out.println("Please fill all fields!");
            return false;
        }

        if (!txtPassword.getText().equals(txtConfirmpassword.getText())) {
            System.out.println("Passwords do not match!");
            return false;
        }

        return true;
    }

    // ⭐ FINAL & ONLY VERSION OF THIS METHOD ⭐
    public void setUserData(UserDTO user) {

        txtUserId.setText(user.getId());
        txtFirstName.setText(user.getFirstName());
        txtLastName.setText(user.getLastName());
        txtUserName.setText(user.getUserName());
        txtPassword.setText(user.getPassword());
        txtConfirmpassword.setText(user.getPassword());

        cbRole.setValue(user.getRole());
        cbStatus.setValue(user.getStatus());

        // Switch UI to EDIT mode
        btnAddNew.setDisable(true);
        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
    }

   @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("Delete");
   }
}
