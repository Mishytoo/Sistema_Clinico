package com.barrientos.sistema_clinico.service;

import com.barrientos.sistema_clinico.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-minutes}")
    private long EXPIRATION_MINUTES;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(Usuario user, Map<String, Object> extraClaims) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_MINUTES*60*1000) );

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)

                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)

                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key generateKey(){
        byte[] secretAsBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(secretAsBytes);
    }


    public Claims extractAllClaims(String jwt){
        return Jwts.parser()
                .verifyWith((SecretKey) generateKey()) // mejor si generateKey() retorna SecretKey
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        /*return Jwts.parserBuilder().setSigningKey(generateKey()).build()
                .parseClaimsJws(jwt).getBody();*/
    }

    public String extractUsername(String jwt) {
        //el metodo valida 3 cosas:
        //1. que el jwt tenga un formato correcto
        //2. que la fecha actual sea menor a la fecha de expiracion
        //3. que las firma recibida sea valida
        return extractAllClaims(jwt).getSubject();
    }
}
