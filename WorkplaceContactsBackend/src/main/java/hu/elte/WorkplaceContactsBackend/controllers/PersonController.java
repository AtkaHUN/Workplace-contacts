/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.WorkplaceContactsBackend.repositories.PersonRepository;


@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository peopleRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Person>> getAll() {
        return ResponseEntity.ok(peopleRepository.findAll());
    }
}
