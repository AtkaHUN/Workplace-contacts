/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.People;
import hu.elte.WorkplaceContactsBackend.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emsgem
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<People>> getAll() {
        return ResponseEntity.ok(peopleRepository.findAll());
    }
}