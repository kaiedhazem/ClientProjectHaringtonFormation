package com.client.Client.Services;

import com.client.Client.Entities.Client;
import com.client.Client.Payload.Response.MessageResponse;
import com.client.Client.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements  IClientService{
    @Autowired
    ClientRepository clientrepo;
    @Override
    public MessageResponse save(Client client) {
        boolean existe = clientrepo.existsByCin(client.getCin());
        if (existe){
            return new MessageResponse("Echec ! Cet client exist déja !");
        }
        clientrepo.save(client);
        return new MessageResponse("Succès Opération réalisée avec succès.");    }

    @Override
    public MessageResponse update(Client client) {
        boolean existe = clientrepo.existsById(client.getId());
        if (!existe){
            return new MessageResponse("Echec ! Cet client n'existe pas  !");
        }
        clientrepo.save(client);
        return new MessageResponse("Succès Opération réalisée avec succès.");
    }

    @Override
    public MessageResponse delete(Long id) {
        Client client = findById(id);
        if (client==null){
            return new MessageResponse("Echec Cet enregistrement n'existe pas !");
        }
        clientrepo.delete(client);
        return new MessageResponse("Succès L'enregistrement à été supprimé avec succès.");
    }

    @Override
    public List<Client> findAll() {
        return clientrepo.findAll();
    }

    @Override
    public Client findById(Long id) {
        Client client = clientrepo.findById(id).orElse(null);
        return client;
    }
}
