package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;

import java.time.LocalDateTime;

public class UserController {

        @FXML
        private Label btnAdd;

        @FXML
        private Button btnCatogeries;

        @FXML
        private Button btnCustomers;

        @FXML
        private Button btnDashboard;

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
        private TableColumn<UserDTO, String> colFirstName;

        @FXML
        private TableColumn<UserDTO, String> colId;

        @FXML
        private TableColumn<UserDTO, String> colLastName;

        @FXML
        private TableColumn<UserDTO, String> colPassword;

        @FXML
        private TableColumn<UserDTO, Roles> colRole;

        @FXML
        private TableColumn<UserDTO, Status> colStatus;

        @FXML
        private TableColumn<UserDTO, LocalDateTime> colUserName;

        @FXML
        private TableView<UserDTO> tblUser;

        @FXML
        void CatogeriesOnAction(ActionEvent event) {

        }

        @FXML
        void DashboardOnAction(ActionEvent event) {

        }

        @FXML
        void LogoutOnAction(ActionEvent event) {

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

    }
