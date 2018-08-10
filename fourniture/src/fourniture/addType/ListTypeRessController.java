/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.addType;

import AlertMaker.AlertMaker;
import controller.MainViewController;
import fourniture.ConnexionClass;
import fourniture.Dao;
import fourniture.addEmp.AddEmpController;
import fourniture.classes.Personne;
import fourniture.classes.TypeRessource;
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
public class ListTypeRessController implements Initializable {

    ObservableList<TypeRessource> list = FXCollections.observableArrayList();

    
    @FXML
    private StackPane CatViewList;
    @FXML
    private TableView<TypeRessource> ListCatView;
    @FXML
    private TableColumn<TypeRessource, String> idCat;
    @FXML
    private TableColumn<TypeRessource, String> typeCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadData();
        initCol();
    }    
    
    private void initCol() {
        idCat.setCellValueFactory(new PropertyValueFactory<>("idType"));
        typeCat.setCellValueFactory(new PropertyValueFactory<>("nomType"));
    }
    
    @FXML
    void loadData() {
        list.clear();

        ConnexionClass handler = ConnexionClass.getInstance();
        String qu = "SELECT * FROM TYPERESSOURCE";
        ResultSet rs = handler.execQuery(qu);
        try {
            while (rs.next()) {
                String id  = rs.getString("idtype");
                String nom = rs.getString("nomtype");
                // convert rs to String 
                System.out.println(nom);
                list.add(new TypeRessource(id, nom));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListCatView.setItems(list);
    }
    @FXML
    private void handleCategorieDeleteOption(ActionEvent event) {
        //Fetch the selected row
        TypeRessource selectedForDeletion = ListCatView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
            AlertMaker.showErrorMessage("Aucune selection", "Veuillez selecter une personne pour la supprimer.");
            return;
        }
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Supprission de la catégorie");
        
        alert.setContentText("Êtes-vous sûr de supprimer " + selectedForDeletion.getNomType() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            Boolean result = Dao.deleteCat(selectedForDeletion);
            if (result) {
                AlertMaker.showSimpleAlert("Catégorie supprimer", selectedForDeletion.getNomType() + " a été supprimer avec succès.");
                list.remove(selectedForDeletion);
            } else {
                AlertMaker.showSimpleAlert("Error", selectedForDeletion.getNomType() + " n'est pas supprimer.");
            }
        } else {
            AlertMaker.showSimpleAlert("Suppression annuler", "Suppression non effectuer.");
        }
    }
    
    
    
    @FXML
    private void handleCatEditOption(ActionEvent event) {
        //Fetch the selected row
        TypeRessource selectedForEdit = ListCatView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showErrorMessage("Aucune Selection", "Veuillez selecter une personne pour la modifier.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("updateType.fxml"));
            Parent parent = loader.load();

            AddTypeController controller = (AddTypeController) loader.getController();
            controller.EditEntires(selectedForEdit);
           
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Catégorie");
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
