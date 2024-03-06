package com.alxsouto.apiauth.repository;

import com.alxsouto.apiauth.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    ClientModel findByEmail(String email);

}
