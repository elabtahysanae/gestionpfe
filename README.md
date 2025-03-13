Gestion des Projets de Fin d’Études (PFE)

Ce projet est une application de gestion des projets de fin d’études (PFE). Elle permet de gérer les projets, les étudiants, leurs encadrements et les associations entre étudiants et projets. L'application est développée en Java avec une base de données MySQL.

Fonctionnalités
Ajouter un projet : Permet d'ajouter un nouveau projet avec son titre, sa description, la date de début et la date de fin.
Associer un étudiant à un projet : Permet d'ajouter un étudiant à un projet en spécifiant le professeur encadrant.
Filtrer les projets par encadrant : Permet de lister tous les projets encadrés par un professeur donné.
Rechercher un projet par titre : Permet de rechercher un projet en fonction de son titre.
Structure de la Base de Données
La base de données MySQL est composée des tables suivantes :

Projet : Contient les informations sur les projets.
Étudiant : Contient les informations sur les étudiants.
Encadrement : Contient les informations sur l'encadrement des projets par les étudiants et les professeurs.
Schéma de la Base de Données:

CREATE TABLE Projet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL
);

CREATE TABLE Étudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prénom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Encadrement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    projet_id INT NOT NULL,
    etudiant_id INT NOT NULL,
    professeur VARCHAR(255) NOT NULL,
    FOREIGN KEY (projet_id) REFERENCES Projet(id),
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id)
);
