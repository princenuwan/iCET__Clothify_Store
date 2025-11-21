package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import service.UserService;
import service.impl.UserServiceImpl;


public class UserController implements Initializable {

    private final UserService userService = new UserServiceImpl();

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnCategories;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnPOS;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnSales;

    @FXML
    private Button btnSuppliers;

    @FXML
    private Button btnUsers;

    @FXML
    private Button btnBtnReports;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAddNew;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnReports;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableView<UserDTO> tblUser;

    Stage stage = new Stage();

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
            Parent root = FXMLLoader.load(getClass().getResource("/view/category/categories.fxml"));

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
    void CustomerOnAction(ActionEvent event){
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
    void SupplierOnAction(ActionEvent event) {
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
    void UsersOnAction(ActionEvent event) {

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

    @FXML
    void AddNewOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/user_form.fxml"));
            Parent root = loader.load();

            UserFormController controller = loader.getController();
            controller.setNewUserId(userService.generateUserId());

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void EditOnAction(ActionEvent event) {
        UserDTO selectedUser = tblUser.getSelectionModel().getSelectedItem();

        if (selectedUser == null) {
            new Alert(Alert.AlertType.WARNING, "Please select a user to edit!").show();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/user_form.fxml"));
            Parent root = loader.load();

            // Get controller of the form
            UserFormController controller = loader.getController();
            controller.setUserData(selectedUser);

            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user/user_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void ViewReporstOnAction(ActionEvent event) {
        System.out.println("You have to develop...");
    }

        ObservableList <UserDTO> userDTOS = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                UserDTO userDTO = new UserDTO(
                        resultSet.getString("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"),
                        Roles.valueOf(resultSet.getString("role")),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getTimestamp("updated_at").toLocalDateTime()
                );
                userDTOS.add(userDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tblUser.setItems(userDTOS);
    }
}
