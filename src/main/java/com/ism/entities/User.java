package com.ism.entities;

import com.ism.entities.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")  // Nom de la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment pour les identifiants
    private Long id;  // Utilisez Long pour une meilleure compatibilité avec les bases de données

    private String login;
    private String nom;
    private String prenom;
    private String password;

    private boolean active;

    @Enumerated(EnumType.STRING)  // Pour stocker le rôle sous forme de chaîne de caractères
    private Role role;

    // Navigation (optionnel)
    @OneToOne(mappedBy = "user")  // Relation un-à-un
    private Client client;
}
