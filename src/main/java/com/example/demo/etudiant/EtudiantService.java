package com.example.demo.etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    public List<Etudiant> getEtudiant(){
        return etudiantRepository.findAll();
    }

    public void ajouterNouvelEtudiant(Etudiant etudiant) {
        Optional<Etudiant> optionEtudiant = etudiantRepository.findEtudiantByEmail(etudiant.getEmail());
        if(optionEtudiant.isPresent()){
            throw new IllegalStateException("Email existe deja");
        }
        etudiantRepository.save(etudiant);
    }
}
