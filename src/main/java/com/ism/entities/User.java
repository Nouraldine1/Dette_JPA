package com.ism.entities;

import com.ism.entities.enums.Role;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")  // Nom de la table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String nom;
    private String prenom;
    private String password;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user")
    private Client client;
}
