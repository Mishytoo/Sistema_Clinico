package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.dto.AuthenticationRequest;
import com.barrientos.sistema_clinico.dto.AuthenticationResponse;
import com.barrientos.sistema_clinico.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private IUsuarioService userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthenticationResponse login(@Valid AuthenticationRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()
        );

        authenticationManager.authenticate(authToken);

        Usuario user = userRepository.findByNomUsuario(authRequest.getUsername()).get();

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        //AuthenticationResponse jwtDto = new AuthenticationResponse(jwt);

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(Usuario user){
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getPersona().getApellidoCompleto() + " " + user.getPersona().getNombreCompleto());
        extraClaims.put("role", user.getTipoUsuario().getCodigoRol());
        //extraClaims.put("permissions", user.getAuthorities());

        extraClaims.put("authorities", user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList()
        );
        return extraClaims;
    }
}
