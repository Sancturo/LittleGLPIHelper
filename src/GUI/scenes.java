package GUI;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class scenes {
    
    public void openNewScene(String window){
            Stage primaryStage = new Stage();
            
            try {
                
            FXMLLoader fxmlLoader = new FXMLLoader();
            String viewerFxml = window;
            AnchorPane page = (AnchorPane)fxmlLoader.load(
                    this.getClass().getResource(viewerFxml));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
            
        
    }
    
    public void openNextScene(String window){
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            
            try {
                loader.load();
            } catch (IOException ex) {
                //Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
    }
    
    
    
    public static void sceneClose(ActionEvent event){
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    
    public static void sceneHide(ActionEvent event){
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }
    
}
