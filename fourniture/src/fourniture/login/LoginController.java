/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.login;

//import com.sun.glass.ui.Window.Level;
//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private AnchorPane Login;
    @FXML
    private JFXButton loginbutton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void close(){
        System.exit(1);
    }

    @FXML
    private void LoadMain(ActionEvent event) throws IOException{  
            if(username.getText().equals("admin") && password.getText().equals("admin")){
                
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("/mainView/mainView.fxml"));
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Fourniture norsys");
                stage.setScene(new Scene(parent));
                stage.show();
            }
            else{
                username.getStyleClass().add("wrong-credentials");
                password.getStyleClass().add("wrong-credentials");
            }
      
}
}
