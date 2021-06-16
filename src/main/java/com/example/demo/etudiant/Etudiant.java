package com.example.demo.etudiant;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Etudiant {
    @Id
    @SequenceGenerator(
            name = "sequence_etudiant",
            sequenceName = "sequence_etudiant",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "sequence_etudiant"
    )
    private Long id;
    private String nom;
    private String email;
    private LocalDate dnais;
    @Transient
    private Integer age;

    public Etudiant() {
    }

    public Etudiant(Long id,
                    String nom,
                    String email,
                    LocalDate dnais) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.dnais = dnais;
    }

    public Etudiant(String nom,
                    String email,
                    LocalDate dnais) {
        this.nom = nom;
        this.email = email;
        this.dnais = dnais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDnais() {
        return dnais;
    }

    public void setDnais(LocalDate dnais) {
        this.dnais = dnais;
    }

    public Integer getAge() {
        return Period.between(this.dnais, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dnais=" + dnais +
                ", age=" + age +
                '}';
    }
}
