package com.ism.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dette")
public class Dette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "montant")
    private double montant;

    @Column(name = "etat")
    private String etat; // Par exemple, "Activé", "Archivé"
}
