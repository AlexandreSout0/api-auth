package com.alxsouto.apiauth.repository;

import com.alxsouto.apiauth.model.AddressModel;
import com.alxsouto.apiauth.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {

    AddressRepository findById(int id);

}
