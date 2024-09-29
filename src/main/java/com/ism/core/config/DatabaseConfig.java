package com.ism.core.config;

import org.yaml.snakeyaml.Yaml;
import lombok.Data;

import java.io.InputStream;
import java.util.Map;

@Data
public class DatabaseConfig {
    private String type;
    private String url;
    private String user;
    private String password;
    private String driver;  
    private String dialect; 

    @SuppressWarnings("unchecked")
    public static DatabaseConfig load() {
        Yaml yaml = new Yaml();
        InputStream inputStream = DatabaseConfig.class
                .getClassLoader()
                .getResourceAsStream("config.yaml");
    
        if (inputStream == null) {
            throw new RuntimeException("Le fichier config.yaml est introuvable.");
        }
    
        // Chargement des propriétés
        Map<String, Object> config = yaml.load(inputStream);
        System.out.println("Configuration chargée : " + config); // Impression pour débogage
        
        DatabaseConfig dbConfig = new DatabaseConfig();
        
        // Charger le type de base de données
        String dbType = (String) ((Map<String, Object>) config.get("database")).get("type"); 
        System.out.println("Type de base de données : " + dbType); // Impression pour débogage
        
        // Vérification du type de base de données
        if (dbType == null) {
            throw new RuntimeException("Le type de base de données est introuvable.");
        }
        
        // Charger les propriétés spécifiques en fonction du type de base de données
        Map<String, String> dbProperties = (Map<String, String>) ((Map<String, Object>) config.get("database")).get(dbType);
        
        // Vérification pour éviter NullPointerException
        if (dbProperties == null) {
            throw new RuntimeException("Les propriétés de base de données pour le type " + dbType + " sont introuvables.");
        }
    
        dbConfig.setType(dbType);
        dbConfig.setUrl(dbProperties.get("url"));
        dbConfig.setUser(dbProperties.get("username"));
        dbConfig.setPassword(dbProperties.get("password"));
        dbConfig.setDriver(dbProperties.get("driver-class-name"));
        dbConfig.setDialect(dbProperties.get("dialect"));
    
        return dbConfig;
    }
}
