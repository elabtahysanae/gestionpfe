/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author elabtahysanae
 */
import java.util.Date;

public class Projet {
    private int id;
    private String titre;
    private String description;
    private Date dateDebut;
    private Date dateFin;

    
    public Projet(int id, String titre, String description, Date dateDebut, Date dateFin) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitre() { 
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateDebut() { return dateDebut;
    }
    public void setDateDebut(Date dateDebut) { 
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin; 
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin; 
    }
}

