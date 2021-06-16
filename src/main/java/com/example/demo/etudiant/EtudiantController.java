package com.example.demo.etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/etudiant")
public class EtudiantController {
    private final EtudiantService etudiantService;
    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getEtudiant(){
        return etudiantService.getEtudiant();
    }

    @PostMapping
    public void ajoutEtudiant(@RequestBody Etudiant etudiant){
       etudiantService.ajouterNouvelEtudiant(etudiant);
    }
}
