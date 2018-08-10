/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture;

import fourniture.classes.Fournisseur;
import fourniture.classes.Personne;
import fourniture.classes.TypeRessource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author computer
 */
public class Dao {
    private final static Logger LOGGER = LogManager.getLogger(ConnexionClass.class.getName());

    public static boolean insertNewPers(Personne res) {
        try {
            PreparedStatement statement = ConnexionClass.getInstance().getConnection().prepareStatement(
                "INSERT INTO PERSONNE(idpersonne,nompersonne,prenompersonne,sexe) VALUES(?,?,?,?)");
            statement.setString(1, res.getId());
            statement.setString(2, res.getNom());
            statement.setString(3, res.getPrenom());
            statement.setString(4, res.getSexe());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
/*
    public static boolean insertNewRess(Ressource res) {
        try {
            PreparedStatement statement = ConnexionClass.getInstance().getConnection().prepareStatement(
                "INSERT INTO RESSOURCE(idressource,nomressource,qte,idtype) VALUES(?,?,?,?,?)");
            statement.setInt(1, res.getId());
            statement.setString(2, res.getNom());
            statement.setInt(3, res.getQte());
            statement.setInt(5, res.getIdType());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
*/
     public static boolean isPersExists(String id) {
        try {
            String checkstmt = "SELECT COUNT(*) FROM PERSONNE WHERE idpersonne=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(checkstmt);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                //System.out.println(count);
                return (count > 0);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
     
    public static boolean deletePers(Personne pers) {
        try {
            String deleteStatement = "DELETE FROM PERSONNE WHERE idpersonne = ?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(deleteStatement);
            stmt.setString(1, pers.getId());
            int res = stmt.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
     
    public static boolean updatePers(Personne pers) {
        try {
            String update = "UPDATE PERSONNE SET NOMPERSONNE=?, PRENOMPERSONNE=?, SEXE=? WHERE IDPERSONNE=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(update);
            stmt.setString(1, pers.getNom());
            stmt.setString(2, pers.getPrenom());
            stmt.setString(3, pers.getSexe());
            stmt.setString(4, pers.getId());
            int res = stmt.executeUpdate();
            return (res > 0);
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    public static boolean isTypeExist(String id){
        try {
            String checkstmt = "Select count(*) from TYPERESSOURCE where idtype=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(checkstmt);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return (count > 0);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    public static boolean insertCategorie(TypeRessource res){
        try {
            PreparedStatement statement = ConnexionClass.getInstance().getConnection().prepareStatement(
                "INSERT INTO TYPERESSOURCE(idtype,nomtype) VALUES(?,?)");
            statement.setString(1, res.getIdType());
            statement.setString(2, res.getNomType());
            System.out.println(res.getNomType());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
    public static boolean deleteCat(TypeRessource cat) {
        try {
            String deleteStatement = "DELETE FROM TYPERESSOURCE WHERE idtype = ?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(deleteStatement);
            stmt.setString(1, cat.getIdType());
            int res = stmt.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
    public static boolean updateCat(TypeRessource Cat) {
        try {
            String update = "UPDATE TYPERESSOURCE SET NOMTYPE=? WHERE IDTYPE=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(update);
            stmt.setString(1, Cat.getNomType());
            stmt.setString(2, Cat.getIdType());
            int res = stmt.executeUpdate();
            return (res > 0);
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
    public static boolean isFrsExist(String id){
        try {
            String checkstmt = "Select count(*) from FOURNISSEUR where idfournisseur=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(checkstmt);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return (count > 0);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
    public static boolean insertNewFrs(Fournisseur Frs){
        try {
            PreparedStatement statement = ConnexionClass.getInstance().getConnection().prepareStatement(
                "INSERT INTO FOURNISSEUR(idfournisseur,nomfournisseur,prenomfournisseur,telfournisseur) VALUES(?,?,?,?)");
            statement.setString(1, Frs.getId());
            statement.setString(2, Frs.getNom());
            statement.setString(3, Frs.getPrenom());
            statement.setString(4, Frs.getTel());
            return statement.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
    public static boolean deleteFrs(Fournisseur fr) {
        try {
            String deleteStatement = "DELETE FROM FOURNISSEUR WHERE idfournisseur = ?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(deleteStatement);
            stmt.setString(1, fr.getId());
            int res = stmt.executeUpdate();
            if (res == 1) {
                return true;
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
     public static boolean updateFrs(Fournisseur frs) {
        try {
            String update = "UPDATE FOURNISSEUR SET NOMFOURNISSEUR=?, PRENOMFOURNISSEUR=?, TELFOURNISSEUR=? WHERE IDFOURNISSEUR=?";
            PreparedStatement stmt = ConnexionClass.getInstance().getConnection().prepareStatement(update);
            stmt.setString(1, frs.getNom());
            stmt.setString(2, frs.getPrenom());
            stmt.setString(3, frs.getTel());
            stmt.setString(4, frs.getId());
            int res = stmt.executeUpdate();
            return (res > 0);
        }
        catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
    
}
