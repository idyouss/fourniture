/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import FournitureUtil.Utility;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DrawerBoxController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void addEmp(ActionEvent event) throws IOException{
        
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addEmp/addEmp.fxml","Ajouter Personnel");
        }
    @FXML
    private void ListEmp(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addEmp/ListEmp.fxml","Liste Personnel");
        }
    @FXML
    private void addCat(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addType/addType.fxml", "Ajouter Catégorie");
    }
    @FXML
    private void ListCat(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addType/ListTypeRess.fxml", "Liste Catégorie");
    }
    
    @FXML
    private void addFrs(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addFournisseur/addFrs.fxml", "Ajouter Fournisseur");
    }
    
    @FXML
    private void ListFrs(ActionEvent event) throws IOException{
        Utility ut = new Utility();
        ut.loadWindow("/fourniture/addFournisseur/ListFrs.fxml", "Liste Fournisseur");
    }
}
