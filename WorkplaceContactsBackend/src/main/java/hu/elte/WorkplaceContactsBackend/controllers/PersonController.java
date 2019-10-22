package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.WorkplaceContactsBackend.repositories.PersonRepository;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository peopleRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Person>> getAll() {
        return ResponseEntity.ok(peopleRepository.findAll());
    }
    
    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Person>> getByNameContaining(@RequestBody Person person) { 
        return ResponseEntity.ok(peopleRepository.findByNameContaining(person.getName()));
    }
}
