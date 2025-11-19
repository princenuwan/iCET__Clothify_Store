//package ui;
//
//import javafx.application.Application;
//import javafx.collections.ObservableList;
//import javafx.scene.Scene;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import model.dto.UserDTO;
//import service.UserService;
//import service.impl.UserServiceImpl;
//
//public class UserApp extends Application {
//
//    private final UserService userService = new UserServiceImpl();
//
//    @Override
//    public void start(Stage stage) {
//        TableView<UserDTO> table = new TableView<>();
//
//        TableColumn<UserDTO, String> idCol = new TableColumn<>("ID");
//        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//
//        TableColumn<UserDTO, String> nameCol = new TableColumn<>("Name");
//        nameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//
//        TableColumn<UserDTO, String> roleCol = new TableColumn<>("Role");
//        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
//
//        table.getColumns().addAll(idCol, nameCol, roleCol);
//
//        // Create sample users
//        userService.createUser(new UserDTO(null, "Nuwan", "Kumara", "nuwank", "pass123", "ADMIN", null, null));
//        userService.createUser(new UserDTO(null, "Kamal", "Perera", "kamalp", "pass456", "MANAGER", null, null));
//
//        ObservableList<UserDTO> users = userService.getAllUsers();
//        table.setItems(users);
//
//        VBox vbox = new VBox(table);
//        Scene scene = new Scene(vbox, 400, 300);
//        stage.setScene(scene);
//        stage.setTitle("Clothify Users");
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
//
