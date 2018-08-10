/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import FournitureUtil.Utility;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import fourniture.ConnexionClass;
import fourniture.classes.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author computer
 */
public class MainViewController implements Initializable {
    
    ObservableList<Personne> list = FXCollections.observableArrayList();

    @FXML
    private JFXHamburger ham;
    @FXML
    private JFXDrawer drawer;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainView/drawerBox.fxml"));
            VBox toolbar = loader.load();
            drawer.setSidePane(toolbar);
            
            HamburgerSlideCloseTransition burg = new HamburgerSlideCloseTransition(ham);
            burg.setRate(-1);
            ham.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
                burg.setRate(burg.getRate()*-1);
                burg.play();
                if (drawer.isOpened()) {
                    drawer.close();
                } else
                    drawer.open(); 
            });
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
    }    
    
    private void addEmp(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addEmp/addEmp.fxml","Ajouter Employé");
        }
   
    
}
