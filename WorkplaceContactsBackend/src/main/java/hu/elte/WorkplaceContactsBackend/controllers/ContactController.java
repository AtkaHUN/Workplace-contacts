package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.entities.Contact;
import hu.elte.WorkplaceContactsBackend.entities.Person;
import hu.elte.WorkplaceContactsBackend.error.ErrorHandler;
import hu.elte.WorkplaceContactsBackend.repositories.ContactRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Person>> getPerson(@RequestBody Contact contact) {
        List<Contact> contacts = contactRepository.findByNameContaining(contact.getContact());
        List<Person> people = new ArrayList<>();
        for(Contact c : contacts) {
            people.add(c.getPerson());
        }
        return ResponseEntity.ok(people);
    }
    
    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody Contact contact) {
        if(contact.getContactType() == null) {
            return ResponseEntity.ok(new ErrorHandler("Enum null", "The enum is null"));
        }
        Contact newContact = contactRepository.save(contact);
        return ResponseEntity.ok(newContact);
    }
}
