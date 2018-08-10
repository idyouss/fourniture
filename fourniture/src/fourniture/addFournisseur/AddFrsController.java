/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addFournisseur;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import fourniture.Dao;
import fourniture.classes.Fournisseur;
import fourniture.classes.Personne;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class AddFrsController implements Initializable {

    @FXML
    private StackPane stack;
    @FXML
    private VBox anchor;
    @FXML
    private JFXTextField idFrs;
    @FXML
    private JFXTextField nomFrs;
    @FXML
    private JFXTextField prenomFrs;
    @FXML
    private JFXTextField telFrs;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void addFrs(ActionEvent event){
        String id = idFrs.getText();
        String nom = nomFrs.getText();
        String prenom = prenomFrs.getText();
        String tel = telFrs.getText();
        
        if (idFrs.getText().trim().isEmpty() || nomFrs.getText().trim().isEmpty() || prenomFrs.getText().trim().isEmpty()) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Data Insuffisante", "Veulliez remplir tous les champs.");
            return;
        } 
        
        if(Dao.isPersExists(id)) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ID dupliqué", "Fournisseur avec même ID : " + idFrs + " exist déja.\nVeulliez utiliser un nouveau ID");
            return;
        }
        Fournisseur bo = new Fournisseur(id,nom, prenom,tel);
        boolean result = Dao.insertNewFrs(bo);
        if (result) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Nouveau FOURNISSEUR :", nomFrs.getText() + " Ajouter avec succès !");
            clearEntries();
        } 
         else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Ajout ÉCHOUÉ", "Verifiez tous les champs et Ressayez a nouveau");
        } 
    }
    
    @FXML
    public void clearEntries(){
        idFrs.setText("");
        nomFrs.setText("");
        prenomFrs.setText("");
        telFrs.setText("");
    }
    
    public void EditEntires(Fournisseur frs) {
        idFrs.setText(frs.getId());
        nomFrs.setText(frs.getNom());
        prenomFrs.setText(frs.getPrenom());
        telFrs.setText(frs.getTel());
        
    }
    
    @FXML
    private void handleEditOperation() {
        Fournisseur frs = new Fournisseur(idFrs.getText(), nomFrs.getText(), prenomFrs.getText(), telFrs.getText());
        if (Dao.updateFrs(frs)) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Succès", "Mise a jour effectuer");
        } else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ÉCHOUÉ", "Mise a jour non effectuer");
        }
        
    }
}
