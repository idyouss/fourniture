/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.classes;



/**
 *
 * @author computer
 */
public class Personne {
    int id;
    String nom;
    String prenom;
    int idDep;

    public Personne(int id, String nom, String prenom, int idDep) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idDep = idDep;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    @Override
    public String toString() {
        return "personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", idDep=" + idDep + '}';
    }
    
}
