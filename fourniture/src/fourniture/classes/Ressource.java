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
public class Ressource {
    int id;
    String nom;
    int qte;
    int idType;

    public Ressource(int id, String nom, int qte, int idType) {
        this.id = id;
        this.nom = nom;
        this.qte = qte;
        this.idType = idType;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getQte() {
        return qte;
    }

    public int getIdType() {
        return idType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "ressource{" + "id=" + id + ", nom=" + nom + ", qte=" + qte + ", idType=" + idType + '}';
    }
    
}
