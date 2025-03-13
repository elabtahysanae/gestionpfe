/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
/**
 *
 * @author elabtahysanae
 */

import beans.Projet;
import connexion.Connexion;
import dao.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public  class ProjetService implements IDao<Projet> {
    private Connexion connexion;

 
    public ProjetService() {
        connexion = Connexion.getInstance();
    }

    public boolean create(Projet projet) {
        String req = "INSERT INTO projet (id, titre, description, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setLong(1, projet.getId());
            ps.setString(2, projet.getTitre());
            ps.setString(3, projet.getDescription());
            ps.setDate(4, new java.sql.Date(projet.getDateDebut().getTime()));  // Convert Date to SQL Date
            ps.setDate(5, new java.sql.Date(projet.getDateFin().getTime()));      // Convert Date to SQL Date

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Projet projet) {
        String req = "DELETE FROM projet WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setLong(1, projet.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean update(Projet projet) {
        String req = "UPDATE projet SET titre = ?, description = ?, dateDebut = ?, dateFin = ? WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);

            ps.setString(1, projet.getTitre());
            ps.setString(2, projet.getDescription());
            ps.setDate(3, new java.sql.Date(projet.getDateDebut().getTime()));  // Convert Date to SQL Date
            ps.setDate(4, new java.sql.Date(projet.getDateFin().getTime()));      // Convert Date to SQL Date
            ps.setLong(5, projet.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public Projet findById(int id) {
        String req = "SELECT * FROM projet WHERE id = ?";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Return a Projet object with the result
                return new Projet(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @Override
    public List<Projet> findAll() {
        List<Projet> projets = new ArrayList<>();
        String req = "SELECT * FROM projet";

        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Add Projet object to list
                projets.add(new Projet(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return projets;
    }
}

