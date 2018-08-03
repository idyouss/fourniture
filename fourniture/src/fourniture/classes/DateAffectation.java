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
public class DateAffectation {
    int idPers;
    int idRess;
    Date dateAffect;

    public DateAffectation(int idPers, int idRess, Date dateAffect) {
        this.idPers = idPers;
        this.idRess = idRess;
        this.dateAffect = dateAffect;
    }

    public int getIdPers() {
        return idPers;
    }

    public int getIdRess() {
        return idRess;
    }

    public Date getDateAffect() {
        return dateAffect;
    }

    public void setIdPers(int idPers) {
        this.idPers = idPers;
    }

    public void setIdRess(int idRess) {
        this.idRess = idRess;
    }

    public void setDateAffect(Date dateAffect) {
        this.dateAffect = dateAffect;
    }

    @Override
    public String toString() {
        return "DateAffectation{" + "idPers=" + idPers + ", idRess=" + idRess + ", dateAffect=" + dateAffect + '}';
    }
    
}
