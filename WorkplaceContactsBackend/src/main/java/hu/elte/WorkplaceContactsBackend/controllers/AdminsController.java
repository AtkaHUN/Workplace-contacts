/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Admins;
import hu.elte.WorkplaceContactsBackend.repositories.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Attila
 */

@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    private AdminsRepository adminsRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Admins>> getAll() {
        return ResponseEntity.ok(adminsRepository.findAll());
    }
}
