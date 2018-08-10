/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addEmp;

import AlertMaker.AlertMaker;
import controller.MainViewController;
import fourniture.ConnexionClass;
import fourniture.Dao;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author computer
 */
public class ListEmpController implements Initializable {
    ObservableList<Personne> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Personne> ListEmpView;
    @FXML
    private TableColumn<Personne, String> nomCol;
    @FXML
    private TableColumn<Personne, String> prenomCol;
    
    @FXML
    private TableColumn<Personne, String> sexeCol;

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
        sexeCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));
    }
    
    // column DEPARTEMENT dont display value  *** MUST FIX ***
    @FXML
    void loadData() {
        list.clear();

        ConnexionClass handler = ConnexionClass.getInstance();
        String qu = "SELECT * FROM PERSONNE";
        ResultSet rs = handler.execQuery(qu);
        try {
            while (rs.next()) {
                String id  = rs.getString("idpersonne");
                String nom = rs.getString("nompersonne");
                String prenom = rs.getString("prenompersonne");
                String sexe = rs.getString("sexe");
                // convert rs to String 
                list.add(new Personne(id, nom, prenom, sexe));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListEmpView.setItems(list);
    }
    
    @FXML
    private void handlePersDeleteOption(ActionEvent event) {
        //Fetch the selected row
        Personne selectedForDeletion = ListEmpView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            AlertMaker.showErrorMessage("Aucune selection", "Veuillez selecter une personne pour la supprimer.");
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprission de Personnel");
        
        alert.setContentText("Êtes-vous sûr de supprimer " + selectedForDeletion.getNom() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Boolean result = Dao.deletePers(selectedForDeletion);
            if (result) {
                AlertMaker.showSimpleAlert("Personne supprimer", selectedForDeletion.getNom() + " a été supprimer avec succès.");
                list.remove(selectedForDeletion);
            } else {
                AlertMaker.showSimpleAlert("Error", selectedForDeletion.getNom() + " n'est pas supprimer.");
            }
        } else {
            AlertMaker.showSimpleAlert("Suppression annuler", "Suppression non effectuer.");
        }
    }
    
    @FXML
    private void handleEmpEditOption(ActionEvent event) {
        //Fetch the selected row
        Personne selectedForEdit = ListEmpView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("Aucune Selection", "Veuillez selecter une personne pour la modifier.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("updateEmp.fxml"));
            Parent parent = loader.load();

            AddEmpController controller = (AddEmpController) loader.getController();
            controller.EditEntires(selectedForEdit);
           
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Personnel");
            stage.setScene(new Scene(parent));
            //ListEmpView.refresh();
            stage.show();
           // Utility.setStageIcon(stage);

            /*stage.setOnCloseRequest((e) -> {
                handleRefresh(new ActionEvent());
            });*/

        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
