package com.client.Client.Controllers;

import com.client.Client.Entities.Client;
import com.client.Client.Payload.Response.MessageResponse;
import com.client.Client.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientservice;
    @GetMapping
    public List<Client> findAll() {
        return clientservice.findAll();
    }
    @PostMapping
    public MessageResponse save(@RequestBody Client client) {
        return clientservice.save(client);
    }
    @PutMapping
    public MessageResponse update(@RequestBody Client client) {
        return clientservice.update(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientservice.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return clientservice.delete(id);
    }
}
