package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private Button btnDashboard;

    @FXML
    private Button btnCategories;

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
    void DashboardOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Dashboard - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML

    void CategoriesOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/categories.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Categories - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void SupplierOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/suppliers.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Suppliers - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ProductOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/products.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Product - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void CustomerOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/customers.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Customers - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void SalesOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/sales.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Sales - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ReportsOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/reports.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Sales - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void PosOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/pos.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Sales - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void UserOnAction(ActionEvent event) {
        try {
            // Load Dashboard UI
            Parent root = FXMLLoader.load(getClass().getResource("/view/users.fxml"));

            // Create a new stage for Dashboard
            Stage dashboardStage = new Stage();
            dashboardStage.setScene(new Scene(root));
            dashboardStage.setTitle("Users - Clothify Store");

            // Center the dashboard window
            dashboardStage.centerOnScreen();
            dashboardStage.show();

            // Close the previous window (login screen)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
                currentStage.centerOnScreen();
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

