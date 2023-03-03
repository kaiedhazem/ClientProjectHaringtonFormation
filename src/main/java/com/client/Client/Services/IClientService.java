package com.client.Client.Services;

import com.client.Client.Entities.Client;
import com.client.Client.Payload.Response.MessageResponse;

import java.util.List;

public interface IClientService {
    public MessageResponse save(Client client);
    public MessageResponse update(Client client);
    public MessageResponse delete(Long id);
    public List<Client> findAll();
    public Client  findById(Long id);
}
