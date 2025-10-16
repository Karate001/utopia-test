/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eustache.api__projet_e_commerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author congo
 */
@RestController
@RequestMapping("/info_produit/produits")
@CrossOrigin(origins = "*")
public class Produit_Controller {
    @Autowired
    private Repository_Produit repository_Prodduit;
    @PostMapping
    public Produit add_produit(@RequestBody Produit produit){
        return repository_Prodduit.save(produit);
    }
    @GetMapping
    public List<Produit> get_all_produits(){
        List<Produit> produits = repository_Prodduit.findAll();
       return produits;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete_produit(@PathVariable Integer id){
        if (!repository_Prodduit.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else{
            repository_Prodduit.deleteById(id);
            return ResponseEntity.ok("Produit supprimé");
        }
    }
}
