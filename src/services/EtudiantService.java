/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
/**
 *
 * @author elabtahysanae
 */

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class EtudiantService implements IDao<Etudiant> {
    private Connexion connexion;

   
    public EtudiantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Etudiant etudiant) {
        String req = "INSERT INTO etudiant (id, nom, prenom, email) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, etudiant.getId());
            ps.setString(2, etudiant.getNom());
            ps.setString(3, etudiant.getPrenom());
            ps.setString(4, etudiant.getEmail());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Etudiant etudiant) {
        String req = "DELETE FROM etudiant WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, etudiant.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Etudiant etudiant) {
        String req = "UPDATE etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);

            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getEmail());
            ps.setInt(4, etudiant.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String req = "SELECT * FROM etudiant WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Return an Etudiant object based on the result set
                return new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "SELECT * FROM etudiant";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Add each Etudiant object to the list
                etudiants.add(new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return etudiants;
    }
}

