package com.ism.services;

import com.ism.entities.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    List<Client> getAllClients();
    Client getClientById(String id);
    Client search(String telephone);
}
