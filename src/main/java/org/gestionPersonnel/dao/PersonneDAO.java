package org.gestionPersonnel.dao;

import org.gestionPersonnel.connexion.Connexion;
import org.gestionPersonnel.model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO {

    public void AddPersonne(Personne personne) {
        Connection connexion = null;
        String sql = "insert into personne values (?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            connexion = Connexion.getConnection();
            stmt = connexion.prepareStatement(sql);
            stmt.setInt(1, personne.getId());
            stmt.setString(2, personne.getNom());
            stmt.setString(3, personne.getPrenom());
            stmt.setString(4, personne.getNumber());
            stmt.setString(5, personne.getEmail());

            int cnt = stmt.executeUpdate();
//            si le count est différent de 0 on envoi un message
            if (cnt != 0) {
                System.out.println("Personne inséré avec succès");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
//methode de suppression de personne
    public void DeletePersonne(int id) {
        String sql = ("DELETE FROM personne where id = ? ");
        Connection connexion = null;
        PreparedStatement stmt = null;

        try {
            connexion = Connexion.getConnection();
            stmt = connexion.prepareStatement(sql);

            stmt.setInt(1, id);

            int cnt = stmt.executeUpdate();
            if(cnt!=0){
                System.out.println("personne supprimer avec succès" +id);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
// method d'actualisation de personne
    public void UpdatePersonne(int id, String nom, String prenom, String number, String email) {
        String sql = ("update personne set nom = ?, prenom = ?, number = ?, email = ? where id = ?");
        Connection connexion = null;
        PreparedStatement stmt = null;

        try {
            connexion = Connexion.getConnection();
            stmt = connexion.prepareStatement(sql);

            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, number);
            stmt.setString(4, email);
            stmt.setInt(5, id);

            int cnt=stmt.executeUpdate();
            if(cnt!=0){
                System.out.println("Personne modifier avec succes");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
// methode get personne by id
    public Personne getPersonneByID(int id) {
        String sql = ("SELECT * FROM personne where id =" +id);
        Connection connexion = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("détails du personnel sélectionné");
        System.out.println("----------------------------------------------------------");
        System.out.format("%s\t%s\t\t%s\t%s\t\t%s\n", "ID", "Nom", "PRENOM", "NUMBER", "EMAIl");
        System.out.println("----------------------------------------------------------");

        try {
            connexion = Connexion.getConnection();
            stmt = connexion.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.format("%d\t%s\t%s\t\t%s\t%s\n",
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("number"),
                        rs.getString("email"));
                System.out.println("----------------------------------------------------------");

            }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }
// methode get all personne
    public List<Personne> getAllPersonnes() {
        String sql = ("SELECT * FROM personne");
        Connection connexion = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        System.out.println("détails du personnel");
        System.out.println("----------------------------------------------------------");
        System.out.format("%s\t%s\t\t%s\t\t%s\t\t%s\n", "ID", "Nom", "PRENOM", "NUMBER", "EMAIl");
        System.out.println("----------------------------------------------------------");
        try {
            connexion = Connexion.getConnection();
            stmt = connexion.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.format("%d\t%s\t\t%s\t\t%s\t%s\n",
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("number"),
                        rs.getString("email"));
                System.out.println("----------------------------------------------------------");

            }

        } catch (SQLException exception) {
            exception.printStackTrace(System.out);
        } finally {
            try {
                Connexion.close(connexion);
            } catch (SQLException exception) {
                exception.printStackTrace(System.out);
            }
        }

        return null;
    }

}
