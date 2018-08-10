/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addFournisseur;

import AlertMaker.AlertMaker;
import controller.MainViewController;
import fourniture.ConnexionClass;
import fourniture.Dao;
import fourniture.addEmp.AddEmpController;
import fourniture.classes.Fournisseur;
import fourniture.classes.Personne;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class ListFrsController implements Initializable {
    ObservableList<Fournisseur> list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Fournisseur, String> nomCol;
    @FXML
    private TableColumn<Fournisseur, String> prenomCol;
    @FXML
    private TableColumn<Fournisseur, String> telCol;
    @FXML
    private TableView<Fournisseur> ListFrsView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        initCol();
    }    
    private void initCol() {
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }
    
    @FXML
    void loadData() {
        list.clear();

        ConnexionClass handler = ConnexionClass.getInstance();
        String qu = "SELECT * FROM FOURNISSEUR";
        ResultSet rs = handler.execQuery(qu);
        try {
            while (rs.next()) {
                String id  = rs.getString("idfournisseur");
                String nom = rs.getString("nomfournisseur");
                String prenom = rs.getString("prenomfournisseur");
                String tel = rs.getString("telfournisseur");
                // convert rs to String 
                list.add(new Fournisseur(id, nom, prenom, tel));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListFrsView.setItems(list);
    }
    
    @FXML
    private void handleFrsDeleteOption(ActionEvent event) {
        //Fetch the selected row
        Fournisseur selectedForDeletion = ListFrsView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            AlertMaker.showErrorMessage("Aucune selection", "Veuillez selecter une personne pour la supprimer.");
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprission de Fournisseur");
        
        alert.setContentText("Êtes-vous sûr de supprimer " + selectedForDeletion.getNom() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Boolean result = Dao.deleteFrs(selectedForDeletion);
            if (result) {
                AlertMaker.showSimpleAlert("Fournisseur supprimer", selectedForDeletion.getNom() + " a été supprimer avec succès.");
                list.remove(selectedForDeletion);
            } else {
                AlertMaker.showSimpleAlert("Error", selectedForDeletion.getNom() + " n'est pas supprimer.");
            }
        } else {
            AlertMaker.showSimpleAlert("Suppression annuler", "Suppression non effectuer.");
        }
    }
    
    @FXML
    private void handleFrsEditOption(ActionEvent event) {
        //Fetch the selected row
        Fournisseur selectedForEdit = ListFrsView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("Aucune Selection", "Veuillez selecter un fournisseur pour le modifier.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("updateFrs.fxml"));
            Parent parent = loader.load();
            AddFrsController controller = (AddFrsController) loader.getController();
            controller.EditEntires(selectedForEdit);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Fournisseur");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
