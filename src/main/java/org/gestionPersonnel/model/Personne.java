package org.gestionPersonnel.model;

public class Personne {

    private int id;
    private String nom;
    private String prenom;
    private String number;
    private String email;

    public Personne(String nom, String prenom, String number, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.email = email;
    }

    // class constructor part
    public Personne(int id, String nom, String prenom, String number, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.email = email;
    }

    public Personne() {

    }

    // getter part
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

//    setter part
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "idpersonne=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
