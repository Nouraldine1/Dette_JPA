package com.ism;

import com.ism.entities.Client;
import com.ism.entities.Dette;
import com.ism.services.ClientServiceImpl;
import com.ism.services.DetteServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ClientServiceImpl clientService = new ClientServiceImpl(entityManager);
        DetteServiceImpl detteService = new DetteServiceImpl(entityManager);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un Client");
            System.out.println("2. Lister les Clients");
            System.out.println("3. Ajouter une Dette");
            System.out.println("4. Lister les Dettes");
            System.out.println("5. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();  

            if (choix == 1) {
                // Ajouter un client
                Client client = new Client();
                System.out.print("Nom: ");
                client.setNom(scanner.nextLine());
                System.out.print("Prénom: ");
                client.setPrenom(scanner.nextLine());
                clientService.addClient(client);
            } else if (choix == 2) {
                // Lister les clients
                List<Client> clients = clientService.listClients();
                System.out.println("Liste des Clients:");
                for (Client c : clients) {
                    System.out.println("ID: " + c.getId() + ", Nom: " + c.getNom() + 
                                       ", Prénom: " + c.getPrenom());
                }
            } else if (choix == 3) {
                // Ajouter une dette
                Dette dette = new Dette();
                System.out.print("Montant: ");
                dette.setMontant(scanner.nextDouble());
                scanner.nextLine();  
                System.out.print("État (Activé/Archivé): ");
                dette.setEtat(scanner.nextLine());
                detteService.addDette(dette);
            } else if (choix == 4) {
                // Lister les dettes
                List<Dette> dettes = detteService.listDettes();
                System.out.println("Liste des Dettes:");
                for (Dette d : dettes) {
                    System.out.println("ID: " + d.getId() + ", Montant: " + d.getMontant() + 
                                       ", État: " + d.getEtat());
                }
            } else if (choix == 5) {
                // Quitter
                System.out.println("Au revoir !");
                break;
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        entityManager.close();
        entityManagerFactory.close();
        scanner.close();
    }
}
