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
import fourniture.Dao;
import fourniture.classes.Personne;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private JFXButton addFieldEmp;
    @FXML
    private Button resetFieldEmp;
    @FXML
    private JFXRadioButton h;
    @FXML
    private ToggleGroup sexe;
    @FXML
    private JFXRadioButton f;
    
    ConnexionClass databaseH;
    
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXTextField id;
    
    @FXML
    private StackPane stack;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // databaseH = databaseH.getInstance();
    }  
    
    @FXML
    private void addEmp(ActionEvent event){
        String idPers = id.getText();
        String nom = nomEmp.getText();
        String prenom = prenomEmp.getText();
        
        //valeur RadioButton
        JFXRadioButton selectedRadioButton = (JFXRadioButton) sexe.getSelectedToggle();
        String sexeValue = selectedRadioButton.getText();
        
        if (id.getText().trim().isEmpty() || nomEmp.getText().trim().isEmpty() || prenomEmp.getText().trim().isEmpty() ) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Data Insuffisante", "Veulliez remplir tous les champs.");
            return;
        } 
        
        if(Dao.isPersExists(idPers)) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ID dupliqué", "Personne avec meme ID : " + idPers + " exist déja.\nVeulliez utiliser un nouveau ID");
            return;
        }
        Personne bo = new Personne(idPers,nom, prenom,sexeValue);
        boolean result = Dao.insertNewPers(bo);
        if (result) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Nouveau EMPLOYE :", nomEmp.getText() + " Ajouter avec succès !");
            clearEntries();
        } 
         else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Ajout ÉCHOUÉ", "Verifiez tous les champs et Ressayez a nouveau");
        }
        
    }
    
    public void EditEntires(Personne pers) {
        id.setText(pers.getId());
        nomEmp.setText(pers.getNom());
        prenomEmp.setText(pers.getPrenom());
        if(pers.getSexe() == "homme"){
        sexe.selectToggle(h);
        }
        else{
            sexe.selectToggle(f);
        }
    }

    @FXML
    public void clearEntries(){
        id.setText("");
        nomEmp.setText("");
        prenomEmp.setText("");
        f.setSelected(false);
        h.setSelected(false);
    }
    
    @FXML
    private void handleEditOperation() {
        JFXRadioButton selectedRadioButton = (JFXRadioButton) sexe.getSelectedToggle();
        String sexeValue = selectedRadioButton.getText();
        Personne pers = new Personne(id.getText(), nomEmp.getText(), prenomEmp.getText(), sexeValue);
        if (Dao.updatePers(pers)) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Succès", "Mise a jour effectuer");
        } else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ÉCHOUÉ", "Mise a jour non effectuer");
        }
        
    }
    
}
