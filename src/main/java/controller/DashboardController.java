package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class DashboardController {

    @FXML
    private Button btnCatogeries;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnPOS;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnReports;

    @FXML
    private Button btnSales;

    @FXML
    private Button btnSuppliers;

    @FXML
    private Button btnUsers;

    @FXML
    void LogoutOnAction(ActionEvent event) {

        //confirmation dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout Confirmation");
        alert.setHeaderText("Are you sure you want to logout?");
        alert.setContentText("Your current session will be closed.");

        // Wait for the user response
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                // Get current stage from the logout button
                Stage currentStage = (Stage) btnLogout.getScene().getWindow();

                // Load login scene
                Parent loginRoot = FXMLLoader.load(getClass().getResource("/view/login_form_controller.fxml"));
                Scene loginScene = new Scene(loginRoot);

                // Set login scene to the same stage
                currentStage.setScene(loginScene);
                currentStage.setTitle("Login - Clothify Store");
                currentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
                // Optionally show error alert
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Failed to load login screen");
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

}

