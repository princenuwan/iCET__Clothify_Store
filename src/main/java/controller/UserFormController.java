package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;
import service.UserService;
import service.impl.UserServiceImpl;

public class UserFormController {
    private final UserService userService = new UserServiceImpl();


    @FXML
    private Button btnAddNew;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private ComboBox<Roles> cbRole;

    @FXML
    private ComboBox<Status> cbStatus;

    @Getter
    @Setter
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
        // Populate ComboBoxes with enum values
        cbRole.setItems(FXCollections.observableArrayList(Roles.values()));
        cbStatus.setItems(FXCollections.observableArrayList(Status.values()));
    }

    public void setNewUserId(String id) {
        txtUserId.setText(id);
    }

    @FXML
    void AddNewOnAction(ActionEvent event) {
        try {
            // 1. Validate required fields
            if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() ||
                    txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty() ||
                    txtConfirmpassword.getText().isEmpty() ||
                    cbRole.getValue() == null || cbStatus.getValue() == null) {
                System.out.println("Please fill all fields!");
                return;
            }

            if (!txtPassword.getText().equals(txtConfirmpassword.getText())) {
                System.out.println("Passwords do not match!");
                return;
            }

            // 2. Create DTO and set values
            UserDTO newUser = new UserDTO();
            newUser.setFirstName(txtFirstName.getText());
            newUser.setLastName(txtLastName.getText());
            newUser.setUserName(txtUserName.getText());
            newUser.setPassword(txtPassword.getText());
            newUser.setRole(Roles.valueOf(cbRole.getValue().name()));   // enum value to String
            newUser.setStatus(Status.valueOf(cbStatus.getValue().name())); // enum value to String

            // 3. Call service layer to save user
            UserDTO savedUser = userService.createUser(newUser);

            // 4. Show confirmation (console for now)
            System.out.println("User saved successfully: " + savedUser.getId());

            // 5. Optionally clear the form
            clearForm();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void BackOnAction(ActionEvent event) {
        // Close form or go back
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        // TODO: delete logic
    }

    @FXML
    void EditOnAction(ActionEvent event) {
        // Example: set values during editing
    }

    @FXML
    public void ClearOnAction(ActionEvent event){
        clearForm();
    }
    private void clearForm() {
        txtFirstName.clear();
        txtLastName.clear();
        txtUserName.clear();
        txtPassword.clear();
        txtConfirmpassword.clear();
        cbRole.getSelectionModel().clearSelection();
        cbStatus.getSelectionModel().clearSelection();
    }
}
