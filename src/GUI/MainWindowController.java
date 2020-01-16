/**
 * Sample Skeleton for 'ipBase.fxml' Controller Class
 */

package GUI;

import POJOs.CurrentUser;
import POJOs.compBase;
import apitest.ManageConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

public class MainWindowController {
    
    public static ObservableList<compBase> compList = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="mainPane"
    private AnchorPane mainPane; // Value injected by FXMLLoader

    @FXML // fx:id="butExit"
    private Button butExit; // Value injected by FXMLLoader

    @FXML // fx:id="compTable"
    private TableView<compBase> compTable; // Value injected by FXMLLoader

    @FXML // fx:id="Num"
    private TableColumn<compBase, Integer> Num; // Value injected by FXMLLoader

    @FXML // fx:id="userName"
    private TableColumn<compBase, String> userName; // Value injected by FXMLLoader

    @FXML // fx:id="compName"
    private TableColumn<compBase, String> compName; // Value injected by FXMLLoader

    @FXML // fx:id="ipAddress"
    private TableColumn<compBase, String> ipAddress; // Value injected by FXMLLoader

    @FXML // fx:id="onlineStat"
    private TableColumn<compBase, String> onlineStat; // Value injected by FXMLLoader

    @FXML // fx:id="butReload"
    private Button butReload; // Value injected by FXMLLoader

    @FXML // fx:id="lbl"
    private Label lbl; // Value injected by FXMLLoader
    
    @FXML
    private Label labelWelcome;

    @FXML
    private Label labelUserName;
    
    public CurrentUser user;
    
    
    
    @FXML
    void clickedBtn(ActionEvent event) {
        Object source = event.getSource();
            if (!(source instanceof Button)) {
                return;}
            Button clickedButton = (Button) source;
            Window parentWindow = ((Node) event.getSource()).getScene().getWindow();
            System.out.println("You`ve pressed " + clickedButton.getText());
            switch (clickedButton.getId()) {
                case "butReload":
                    labelUserName.setText(user.getUsername());
                    apitest.APITest.makeRequest();
                    break;
                case "butExit":
                    scenes.sceneClose(event);
                    break;
            }
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        initData();
        compTable.setEditable(true);
        Num.setCellValueFactory(new PropertyValueFactory<>("number"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        compName.setCellValueFactory(new PropertyValueFactory<>("compName"));
        ipAddress.setCellValueFactory(new PropertyValueFactory<>("IPaddress"));
        onlineStat.setCellValueFactory(new PropertyValueFactory<>("status"));
        compTable.setItems(compList);
        System.out.println(user);
        labelUserName.setText(user.getUsername());
    }
    
    void initData(){
        compList.clear();
        apitest.APITest.makeRequest();
    }
    
    public void setUser(CurrentUser user){
        this.user = user;
        System.out.println("Got a name! " + user.getUsername());
    }
}
