package test;

import beans.Encadrement;
import beans.Etudiant;
import beans.Projet;
import services.EncadrementService;
import services.EtudiantService;
import services.ProjetService;
import java.util.Date;

public class Test {
    public static void main(String[] args) { 
        ProjetService ps = new ProjetService();
        EtudiantService es = new EtudiantService();
        EncadrementService ens = new EncadrementService();
       
        Projet projet = new Projet(1, "Développement Web", "Projet sur le développement d'une application web", new Date(), new Date());
        Etudiant etudiant = new Etudiant(2, "Ahmadi", "Hassan", "hassan@gmail.com");
        Encadrement encadrement = new Encadrement(projet, etudiant, "Berrada Karim");
        
      
        projet.setTitre("Développement Mobile");
        ps.update(projet);
        etudiant.setEmail("hassan.updated@gmail.com");
        es.update(etudiant);
        Encadrement encadrementFetched = ens.findById(1);
        if (encadrementFetched != null) {
            encadrementFetched.getEtudiant();
            ens.update(encadrementFetched);
        }
        
        ens.delete(encadrement);
        es.delete(etudiant);
        ps.delete(projet);
        
        System.out.println("### List of Projets ###");
        for (Projet p : ps.findAll()) {
            System.out.println(p);
        }
        System.out.println("-------------------");
        
        System.out.println("### List of Etudiants ###");
        for (Etudiant e : es.findAll()) {
            System.out.println(e);
        }
        System.out.println("-------------------");
        
        System.out.println("### List of Encadrants ###");
        for (Encadrement e : ens.findAll()) {
            System.out.println(e);
        }
    }
}
