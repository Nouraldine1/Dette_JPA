package com.ism.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @OneToOne
    @JoinColumn(name = "user_id")  // Spécifie la clé étrangère
    private User user;
}
