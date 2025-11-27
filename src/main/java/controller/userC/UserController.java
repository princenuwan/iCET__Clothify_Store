package controller.userC;

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
import lombok.RequiredArgsConstructor;
import model.dto.UserDTO;
import model.enums.Roles;
import model.enums.Status;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RequiredArgsConstructor
public class UserController implements Initializable {

    private final UserService userService = new UserServiceImpl();

    @FXML
    private TableView<UserDTO> tblUser;

    @FXML
    private TableColumn<UserDTO, String> colId, colFirstName, colLastName, colUserName, colPassword;

    @FXML
    private TableColumn<UserDTO, Roles> colRole;

    @FXML
    private TableColumn<UserDTO, Status> colStatus;

    private final ObservableList<UserDTO> userDTOS = FXCollections.observableArrayList();
    private final Stage stage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadUserTable();
    }

    public void loadUserTable() {
        userDTOS.clear();
        List<UserDTO> users = userService.getAllUsers();
        userDTOS.addAll(users);
        tblUser.setItems(userDTOS);
    }

    @FXML
    void AddNewOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/user_form.fxml"));
            Parent root = loader.load();

            UserFormController controller = loader.getController();
            controller.setNewUserId(userService.generateUserId());
            controller.setParentController(this);

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

            UserFormController controller = loader.getController();
            controller.setUserData(selectedUser);
            controller.setParentController(this);

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {
        System.out.println("No");
    }
}
