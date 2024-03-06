package com.alxsouto.apiauth.controller;


import com.alxsouto.apiauth.dto.AuthResponseDTO;
import com.alxsouto.apiauth.dto.AuthenticationDTO;
import com.alxsouto.apiauth.dto.ClientModelDTO;
import com.alxsouto.apiauth.dto.RegisterDTO;
import com.alxsouto.apiauth.model.ClientModel;
import com.alxsouto.apiauth.repository.ClientRepository;
import com.alxsouto.apiauth.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private ClientRepository clientRepository;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthenticationDTO data) {
        return ResponseEntity.ok(authenticationService.produceAuthentication(data));
    }
    @PostMapping("/register")
    public ResponseEntity<ClientModelDTO> register(@RequestBody RegisterDTO data) {

        return ResponseEntity.ok().body(authenticationService.registerClient(data));
    }
    @GetMapping("/validar")
    public ResponseEntity<String> validarToken (@RequestParam("token") String token) {
        if(authenticationService.validateToken(token)){
            return new ResponseEntity<>("Token Não Autorizado", HttpStatus.UNAUTHORIZED);
        };
        return new ResponseEntity<>("Token Autorizado",HttpStatus.ACCEPTED);
    }
    @GetMapping("/usuario/{login}")
    public ResponseEntity<ClientModel> getUsuario(@PathVariable("login") String login) {
        return ResponseEntity.ok().body(clientRepository.findByEmail(login));
    }

}
