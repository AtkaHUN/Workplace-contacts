/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.WorkplaceContactsBackend.repositories.AdminRepository;

/**
 *
 * @author Attila
 */

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository adminsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Admin>> getAll() {
        return ResponseEntity.ok(adminsRepository.findAll());
    }
}
