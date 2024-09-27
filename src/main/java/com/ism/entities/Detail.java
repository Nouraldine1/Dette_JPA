package com.ism.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "details")  // Nom de la table
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment pour les identifiants
    private Long id;  // Utilisez Long pour une meilleure compatibilité avec les bases de données

    private int quantite;

    @ManyToOne  // Relation plusieurs-à-un avec Dette
    @JoinColumn(name = "dette_id", nullable = false)  // Clé étrangère
    private Dette dette;

    @ManyToOne  // Relation plusieurs-à-un avec Article
    @JoinColumn(name = "article_id", nullable = false)  // Clé étrangère
    private Article article;
}
