package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.UserDTO;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    private final UserService userService = new UserServiceImpl();

    Stage stage = new Stage();
    @FXML
    void loginOnAction(ActionEvent event) throws RuntimeException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        // Super admin check (optional)
        if ("Admin".equals(username) && "Admin#123".equals(password)) {
            openDashboard(event);
            return;
        }

        // Check user from DB
        UserDTO user = userService.getUserByUsername(username); // You need to implement this in service & repository
        if (user != null && user.getPassword().equals(password)) {
            openDashboard(event);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password. Please try again.");
            alert.showAndWait();
        }
    }

    private void openDashboard(ActionEvent event) {
        try {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
            Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            loginStage.close();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}