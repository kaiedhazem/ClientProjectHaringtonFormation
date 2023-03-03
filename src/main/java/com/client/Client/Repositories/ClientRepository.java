package com.client.Client.Repositories;

import com.client.Client.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    boolean existsByCin(Long cin);
}
