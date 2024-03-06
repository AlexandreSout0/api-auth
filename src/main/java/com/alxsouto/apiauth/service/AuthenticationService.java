package com.alxsouto.apiauth.service;


import com.alxsouto.apiauth.dto.AuthResponseDTO;
import com.alxsouto.apiauth.dto.AuthenticationDTO;
import com.alxsouto.apiauth.dto.ClientModelDTO;
import com.alxsouto.apiauth.dto.RegisterDTO;
import com.alxsouto.apiauth.exception.ApiRequestException;
import com.alxsouto.apiauth.model.ClientModel;
import com.alxsouto.apiauth.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final ClientRepository clientRepository;

    public AuthResponseDTO produceAuthentication(AuthenticationDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(userNamePassword);
        return new AuthResponseDTO(tokenService.generateToken((ClientModel)auth.getPrincipal()),clientRepository.findByEmail(data.email()).getId());
    }

    public boolean validateToken(String token){
        return tokenService.validateToken(token).isEmpty();
    }


    public ClientModelDTO registerClient( RegisterDTO client) {
        if (this.clientRepository.findByEmail(client.email()) != null) {
            throw new ApiRequestException("Já existe um cliente cadastrado com este e-mail.");
        }

        //TODO validações

        String encryptPassword = new BCryptPasswordEncoder().encode(client.password());

        ClientModel newClientModel = new ClientModel(
                client.email(),
                encryptPassword,
                client.name(),
                client.cpf(),
                client.phone(),
                client.birthday());
        newClientModel = this.clientRepository.save(newClientModel);


        return new ClientModelDTO(
                newClientModel.getId(),
                newClientModel.getEmail(),
                newClientModel.getName(),
                newClientModel.getPhone(),
                newClientModel.getCpf(),
                newClientModel.getBirthday());

    }
}
