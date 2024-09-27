package com.ism.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "prixAppro")
    private double prixAppro;

    @Column(name = "qteStock")
    private int qteStock;
}
