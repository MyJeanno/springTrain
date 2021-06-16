package com.example.demo.etudiant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EtudiantConfig {
    @Bean
    CommandLineRunner commandLineRunner(EtudiantRepository repository){
        return args -> {
            Etudiant e1 = new Etudiant(
                        "Jean",
                        "jean@gmail.com",
                        LocalDate.of(2000, Month.JANUARY,5)
            );
            Etudiant e2 = new Etudiant(
                    "Kossi",
                    "kossi@gmail.com",
                    LocalDate.of(1995, Month.APRIL,15)
           );
            repository.saveAll(List.of(e1,e2));
        };
    }
}
