/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourniture.classes;

import java.util.Date;
/**
 *
 * @author computer
 */
public class Commande {
    int idFour;
    int idRess;
    Date dateCmd;

    public Commande(int idFour, int idRess, Date dateCmd) {
        this.idFour = idFour;
        this.idRess = idRess;
        this.dateCmd = dateCmd;
    }

    public int getIdFour() {
        return idFour;
    }

    public int getIdRess() {
        return idRess;
    }

    public Date getDateCmd() {
        return dateCmd;
    }

    public void setIdFour(int idFour) {
        this.idFour = idFour;
    }

    public void setIdRess(int idRess) {
        this.idRess = idRess;
    }

    public void setDateCmd(Date dateCmd) {
        this.dateCmd = dateCmd;
    }

    @Override
    public String toString() {
        return "Commande{" + "idFour=" + idFour + ", idRess=" + idRess + ", dateCmd=" + dateCmd + '}';
    }
    
    
    
}
