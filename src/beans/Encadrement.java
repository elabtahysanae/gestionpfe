/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package beans;

/**
 *
 * @author elabtahysanae
 */

public class Encadrement {
  
    private Projet projet;
    private Etudiant etudiant;
    private String professeur;

   
    public Encadrement(projet projet, Etudiant etudiant, String professeur) {

       this.projet = projet;
        this.etudiant = etudiant;
        this.professeur = professeur;
    }

   

    public Projet getProjet() { 
        return projet;
    }
    public void setProjet(Projet projet) { 
        this.projet = projet; 
    }

    public Etudiant getEtudiant() { 
        return etudiant; 
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant; 
    }

    public String getProfesseur() {
        return professeur; 
    }
    public void setProfesseur(String professeur) { 
        this.professeur = professeur;
    }
}

