package com.barrientos.sistema_clinico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SistemaClinicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaClinicoApplication.class, args);
    }

}
