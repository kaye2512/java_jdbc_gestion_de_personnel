package org.gestionPersonnel;

import org.gestionPersonnel.dao.PersonneDAO;
import org.gestionPersonnel.model.Personne;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nom;
        String prenom;
        String number;
        String email;
        int id;
        PersonneDAO personneDAO = new PersonneDAO();
        System.out.println("Bienvenue sur l'application de management du personnel");
//      import le scanner pour saisir les information
        Scanner scanner = new Scanner(System.in);
//        Création du menu de l'application
        do {
            System.out.println("1 . créer une personne\n" +
                    "2 . afficher toutes les personnes\n" +
                    "3 . afficher  une personne par son id\n" +
                    "4 . update une personne\n" +
                    "5 . supprimer une personne\n"
            );
            System.out.println("Que voulez vous faire sur l'application: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    Personne personne = new Personne();
//                    les details reçu par de l'utilisateur

                    // parti pour saisir le nom de la personne
                    System.out.println("Saisissez un Nom: ");
                     nom = scanner.next();

                    // parti pour saisir le prenom de la personne
                    System.out.println("Saisissez un Prenom: ");
                     prenom = scanner.next();

                    // parti pour saisir le number de la personne
                    System.out.println("Saisissez un Number: ");
                     number = scanner.next();

                    // parti pour saisir le email de la personne
                    System.out.println("Saisissez un Email: ");
                     email = scanner.next();

                    // Set les informations dans la base de donnée1
                    personne.setNom(nom);
                    personne.setPrenom(prenom);
                    personne.setNumber(number);
                    personne.setEmail(email);
                    personneDAO.AddPersonne(personne);
                    break;

                case 2:

                    personneDAO.getAllPersonnes();
                    break;

                case 3:
                    System.out.println("Entrer l'id de la personne pour l'afficher");
                     id = scanner.nextInt();
                    personneDAO.getPersonneByID(id);
                    break;

                case 4:
                    System.out.println("Saisie l'id de la personne à modifier");
                     id = scanner.nextInt();
                    System.out.println("Entrer le nom");
                    nom = scanner.next();

                    System.out.println("Entrer le prenom");
                    prenom = scanner.next();

                    System.out.println("Entrer le number");
                    number = scanner.next();

                    System.out.println("Entrer le email");
                    email = scanner.next();
                    personneDAO.UpdatePersonne(id,nom,prenom,number,email);
                    break;

                case 5:
                    System.out.println("Saisissez l'id de la personne a supprimer");
                    id = scanner.nextInt();
                    personneDAO.DeletePersonne(id);
                    break;
                case 6:
                    System.out.println("Merci !!");
                    System.exit(0);
                default:
                    System.out.println("saisissez un choix valide !");
                    break;

            }
        } while (true);

    }

}
