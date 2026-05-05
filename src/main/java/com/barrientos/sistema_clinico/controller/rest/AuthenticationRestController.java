package com.barrientos.sistema_clinico.controller.rest;

import com.barrientos.sistema_clinico.dto.AuthenticationRequest;
import com.barrientos.sistema_clinico.dto.AuthenticationResponse;
import com.barrientos.sistema_clinico.service.AuthenticationService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll") //COMENTAR SI SE QUIERE USAR builderRequestMatchers()
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>
        login(@RequestBody @Valid AuthenticationRequest authRequest){
        AuthenticationResponse jwtDto = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwtDto);
    }

    @PreAuthorize("permitAll") //COMENTAR SI SE QUIERE USAR builderRequestMatchers()
    @GetMapping("/public-access")
    //public ResponseEntity<String>
    public String publicAccessEndpoint(){
        return "este endpoint es publico";
    }
}
