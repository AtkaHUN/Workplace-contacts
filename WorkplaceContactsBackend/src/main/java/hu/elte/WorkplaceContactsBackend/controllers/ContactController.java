package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Contact;
import hu.elte.WorkplaceContactsBackend.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Contact>> getAll() {
        return ResponseEntity.ok(contactRepository.findAll());
    }
}
