package GUI;



import POJOs.CurrentUser;
import apitest.ManageConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class authorisationWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button auth;

    public CurrentUser user;
    
   
    @FXML
    void initialize() {
                
        auth.setOnAction((event) -> {
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();

            if(!login.equals("")&& !password.equals("")){
                System.out.println("Login");//loginUser(login,password);
                String sesToken = ManageConnection.getSessionToken(login, password);
                if(ManageConnection.getSessionToken(login, password) != null){
                    scenes.sceneClose(event);
                    System.out.println("Got session token: " + sesToken);
                    scenes mainWindow = new scenes();
                    user = new CurrentUser();
                    user.setUsername(login);
                    user.setPassword(password);
                    user.setSessionToken(sesToken);
                    //mainWindow.openNextScene("/GUI/ipBase.fxml");
//                    FXMLLoader loader = new FXMLLoader("/sample/EditBook.fxml");
//                    Parent root = loader.load();
//                    Main.primaryStage.setScene(new Scene(root));
//                    ControllerClass controllerEditBook = loader.getController(); //получаем контроллер для второй формы
//                    controllerEditBook.someMethod(someParameters); // передаем необходимые параметры
//                    Main.primaryStage.show();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/GUI/ipBase.fxml"));
                    System.out.println("FXML loaded");
                        try {
                            loader.load();
                        } catch (IOException ex) {}                        
                        MainWindowController controller = loader.getController(); //получаем контроллер для второй формы
                        controller.setUser(user);
                        System.out.println(user);
                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));

                        stage.showAndWait();
                            }                
                        }
                        else
                            System.out.println("Login and/or password fields are empty");
                    });



    }
    public CurrentUser getUser(){
        return user;
    }

    
}
