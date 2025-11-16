package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    Stage stage = new Stage();
    @FXML
    void loginOnAction(ActionEvent event) throws RuntimeException {
        //This is for supper admin
       if ("Admin".equals(txtUsername.getText()) && "Admin#123".equals(txtPassword.getText())) {
           try {
               stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           stage.show();
       }else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Login Failed");
           alert.setHeaderText(null);
           alert.setContentText("Invalid username or password. Please try again.");
           alert.showAndWait();
       }
    }

}