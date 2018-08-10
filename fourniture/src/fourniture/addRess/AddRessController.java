/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addRess;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import fourniture.ConnexionClass;
import fourniture.Dao;
import fourniture.classes.Ressource;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class AddRessController implements Initializable {

    @FXML
    private JFXTextField idRess;
    @FXML
    private JFXTextField nomRess;
    @FXML
    private JFXTextField qteRess;
    @FXML
    private JFXComboBox<Integer> typeRess;
    @FXML
    private JFXButton btnValider;
    @FXML
    private JFXButton btnAnnuler;

    ConnexionClass databaseH;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseH = databaseH.getInstance();
    }   
    /*
    @FXML
    private void addRess(ActionEvent event){
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
        
    }*/
    
    
}
