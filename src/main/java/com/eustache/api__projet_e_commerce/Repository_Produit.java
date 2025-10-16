/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eustache.api__projet_e_commerce;
import com.eustache.api__projet_e_commerce.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author congo
 */
@Repository
public interface Repository_Produit extends JpaRepository<Produit,Integer>{

    
}
