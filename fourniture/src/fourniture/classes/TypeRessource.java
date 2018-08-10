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
public class TypeRessource {
    String idType;
    String nomType;

    public TypeRessource(String idType, String nomType) {
        this.idType = idType;
        this.nomType = nomType;
    }

    public String getIdType() {
        return idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    @Override
    public String toString() {
        return "TypeRessource{" + "idType=" + idType + ", nomType=" + nomType + '}';
    }
    
}
