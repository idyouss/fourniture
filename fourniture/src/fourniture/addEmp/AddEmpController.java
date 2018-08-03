/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addEmp;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import fourniture.ConnexionClass;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class AddEmpController implements Initializable {

    @FXML
    private JFXTextField nomEmp;
    @FXML
    private JFXTextField prenomEmp;
    @FXML
    private JFXTextField idDep;
    @FXML
    private JFXButton addFieldEmp;
    @FXML
    private JFXButton resetFieldEmp;
    @FXML
    private JFXRadioButton h;
    @FXML
    private ToggleGroup sexe;
    @FXML
    private JFXRadioButton f;

    ConnexionClass databaseH;
    @FXML
    private StackPane stack;
    @FXML
    private AnchorPane anchor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseH = databaseH.getInstance();
    }    
    @FXML
    private void addEmp(ActionEvent event){
        String nom = nomEmp.getText();
        String prenom = prenomEmp.getText();
        //int idDepart = Integer.parseInt(idDep.getText());
        String idDepart = idDep.getText();
        if(nom.isEmpty() || prenom.isEmpty() || idDepart.isEmpty()){
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Insufficient Data", "Please enter data in all fields.");
            return;
        }
        
    }
    
}
