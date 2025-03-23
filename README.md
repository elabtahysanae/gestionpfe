#  Gestion des Projets de Fin d'Études (PFE)

##  Contexte

Dans le cadre de la gestion des **Projets de Fin d'Études (PFE)** au sein d'une institution académique, il est essentiel de disposer d'un outil efficace pour le suivi et la gestion des projets des étudiants. Cet outil permettra de **centraliser** les informations relatives aux projets, aux étudiants et aux professeurs encadrants, facilitant ainsi la **supervision et l'évaluation** des travaux.

---

##  Problématique

Actuellement, le suivi des PFE est réalisé de manière **fragmentée**, utilisant des **méthodes manuelles** ou des **outils disparates**. Cela entraîne des **difficultés** dans la gestion des informations, la communication entre les acteurs et la production de rapports précis.

---

##  Objectifs

-  **Centraliser les informations :** Regrouper toutes les données relatives aux PFE, aux étudiants et aux professeurs encadrants dans une base de données unique.
-  **Faciliter la gestion :** Offrir une interface conviviale pour la création, la modification et la suppression des PFE.
-  **Améliorer le suivi :** Permettre aux professeurs encadrants de suivre l'avancement des projets de leurs étudiants.
-  **Optimiser la recherche :** Permettre une recherche efficace des PFE par titre et un filtrage par professeur.

---

##  Diagramme Use Case

![Diagramme use case]<img width="542" alt="usecase" src="https://github.com/user-attachments/assets/07142a8a-a6eb-42c7-8fe2-c646aba76870" />


---

##  Diagramme de Classe

![Diagramme de classe](src/images/diagrammeClasse.png)

---

##  Structure de la Base de Données

Le système repose sur **trois tables principales** :

1.  **Projet** : Informations sur les projets *(id, titre, description, dates de début et de fin).*
2.  **Etudiant** : Informations sur les étudiants *(id, nom, prénom, email).*
3.  **Encadrement** : Lien entre les projets, les étudiants et les professeurs *(projet_id, etudiant_id, professeur).*

###  Script de la Base de Données

```sql
CREATE TABLE etudiant (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(255) NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE projet (
    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT NULL,
    dateDebut DATE NULL,
    dateFin DATE NULL
);

CREATE TABLE encadrement (
    projet_id INT(11) NOT NULL,
    etudiant_id INT(11) NOT NULL,
    professeur VARCHAR(255) NULL,
    PRIMARY KEY (projet_id, etudiant_id),
    FOREIGN KEY (projet_id) REFERENCES projet(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (etudiant_id) REFERENCES etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE
);
```

---

##  Architecture

![Architecture](src/images/archetecture.png)

---

##  Technologies

- ** Langage :** Java
- ** Framework d'interface graphique :** Java Swing
- ** Base de données :** MySQL
- ** Bibliothèque graphique :** JFreeChart
- ** Outils de développement :**
  -  IDE Java : NetBeans
  -  Outil de diagramme : draw.io
  -  Outil de gestion de base de données : phpMyAdmin
- ** Accès aux données :** JDBC

---

##  Vidéo sur les interfaces de l'application

🔗 [Voir la vidéo](https://github.com/user-attachments/assets/a7f188b7-c6f9-4046-b48c-512cdded63df)

---

