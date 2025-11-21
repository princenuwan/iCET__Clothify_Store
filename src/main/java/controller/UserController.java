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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class UserController implements Initializable {

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

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserName;

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

    }

    @FXML
    void PosOnAction(ActionEvent event) {

    }

    @FXML
    void ProductOnAction(ActionEvent event) {

    }

    @FXML
    void SalesOnAction(ActionEvent event) {

    }

    @FXML
    void SupplierOnAction(ActionEvent event) {

    }

    @FXML
    void UsersOnAction(ActionEvent event) {

    }

    @FXML
    void LogoutOnAction(ActionEvent event) {

    }

    @FXML
    void AddNewOnAction(ActionEvent event) {

    }

    @FXML
    void DeleteOnAction(ActionEvent event) {

    }

    @FXML
    void EditOnAction(ActionEvent event) {

    }

    @FXML
    void ViewReporstOnAction(ActionEvent event) {

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
