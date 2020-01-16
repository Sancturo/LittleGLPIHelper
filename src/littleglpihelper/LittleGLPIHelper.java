/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package littleglpihelper;

import GUI.scenes;
import javafx.application.Application;
import javafx.stage.Stage;

public class LittleGLPIHelper extends Application {
  
    @Override
    public void start(Stage primaryStage) {
        scenes authWindow = new scenes();
        authWindow.openNewScene("/GUI/authorisationWindow.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
    

}
