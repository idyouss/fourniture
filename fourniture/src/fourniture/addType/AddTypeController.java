/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addType;

import AlertMaker.AlertMaker;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fourniture.Dao;
import fourniture.classes.TypeRessource;
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
public class AddTypeController implements Initializable {

    @FXML
    private JFXTextField idCat;
    @FXML
    private JFXTextField nomCat;
    @FXML
    private JFXButton addCat;
    @FXML
    private JFXButton resetCat;
    @FXML
    private StackPane stack;
    @FXML
    private VBox anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void clearEntries(){
        idCat.setText("");
        nomCat.setText("");
    }
    @FXML
    private void addCategorie(ActionEvent event){
        String id = idCat.getText();
        String nom = nomCat.getText();
        
        if(idCat.getText().trim().isEmpty() || nomCat.getText().trim().isEmpty()){
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Data Insuffisante", "Veulliez remplir tous les champs.");
            return;
        }
        if(Dao.isTypeExist(idCat.getText())){
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ID dupliqué", "Type Categorie avec meme ID : " + id + " exist déja.\nVeulliez utiliser un nouveau ID");
            return;
        }
        TypeRessource res = new TypeRessource(id,nom);
        boolean result = Dao.insertCategorie(res);
        if(result){
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Nouvelle Categorie :", nomCat.getText() + " Ajouter avec succès !");
            clearEntries();
        }
        else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Ajout ÉCHOUÉ", "Verifiez tous les champs et Ressayez a nouveau");
        }
    }
     public void EditEntires(TypeRessource cat) {
        idCat.setText(cat.getIdType());
        nomCat.setText(cat.getNomType());
        
    }
     
    @FXML
    private void handleEditOperation() {
        TypeRessource cat = new TypeRessource(idCat.getText(), nomCat.getText());
        if (Dao.updateCat(cat)) {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "Succès", "Mise a jour effectuer");
        } else {
            AlertMaker.showMaterialDialog(stack, anchor, new ArrayList<>(), "ÉCHOUÉ", "Mise a jour non effectuer");
        }
        
    }

}
