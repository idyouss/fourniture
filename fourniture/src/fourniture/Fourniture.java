/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.derby.iapi.error.ExceptionUtil;
import org.apache.logging.log4j.LogManager;

//import javafx.stage.StageStyle;

/**
 *
 * @author computer
 */
public class Fourniture extends Application {
        private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Fourniture.class.getName());

    @Override
    public void start(Stage stage){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("/fourniture/login/Login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("view/Personne.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            } catch (IOException ex) {
            Logger.getLogger(Fourniture.class.getName()).log(Level.SEVERE, null, ex);
            }            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
