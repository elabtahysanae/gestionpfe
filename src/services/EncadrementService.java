/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
/**
 *
 * @author elabtahysanae
 */

import beans.Encadrement;
import beans.Etudiant;
import beans.Projet;  
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EncadrementService implements IDao<Encadrement> {
    private Connexion connexion;

   
    public EncadrementService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Encadrement encadrement) {
        String req = "INSERT INTO encadrement (id, projet_id, etudiant_id, professeur) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            
            ps.setLong(2, encadrement.getProjet().getId());  
            ps.setInt(3, encadrement.getEtudiant().getId());  
            ps.setString(4, encadrement.getProfesseur());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return false;
    }

    @Override
    public boolean delete(Encadrement encadrement) {
        String req = "DELETE FROM encadrement WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
           
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }

        return false;
    }

    @Override
    public boolean update(Encadrement encadrement) {
        String req = "UPDATE encadrement SET projet_id = ?, etudiant_id = ?, professeur = ? WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);

            ps.setLong(1, encadrement.getProjet().getId());  
            ps.setInt(2, encadrement.getEtudiant().getId());  
            ps.setString(3, encadrement.getProfesseur());
          

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
        }

        return false;
    }

    @Override
    public Encadrement findById(int id) {
        String req = "SELECT * FROM encadrement WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
         
                 
             ProjetService projetService = new ProjetService();
             EtudiantService etudiantService = new EtudiantService();

             Projet projet = projetService.findById(rs.getInt("projet_id"));
              Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));


            
                return new Encadrement(
           
                    projet,
                    etudiant,
                    rs.getString("professeur")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }

        return null;
    }

    @Override
    public List<Encadrement> findAll() {
        List<Encadrement> encadrements = new ArrayList<>();
        String req = "SELECT * FROM encadrement";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 
                int etudiantId = rs.getInt("etudiant_id");  

                ProjetService projetService = new ProjetService();
                EtudiantService etudiantService = new EtudiantService();

                Projet projet = projetService.findById(rs.getInt("projet_id"));
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));


                encadrements.add(new Encadrement(
                   
                    projet,
                    etudiant,
                    rs.getString("professeur")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }

        return encadrements;
    }
}

