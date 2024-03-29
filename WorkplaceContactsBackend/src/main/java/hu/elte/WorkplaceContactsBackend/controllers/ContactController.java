package hu.elte.WorkplaceContactsBackend.controllers;

import hu.elte.WorkplaceContactsBackend.DTO.ContactDTO;
import hu.elte.WorkplaceContactsBackend.entities.Contact;
import hu.elte.WorkplaceContactsBackend.entities.Contact.ContactType;
import hu.elte.WorkplaceContactsBackend.entities.Person;
import hu.elte.WorkplaceContactsBackend.error.ErrorHandler;
import org.springframework.http.HttpStatus;
import hu.elte.WorkplaceContactsBackend.lib.ContactValidator;
import hu.elte.WorkplaceContactsBackend.repositories.ContactRepository;
import hu.elte.WorkplaceContactsBackend.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private PersonRepository peopleRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Contact>> getAll() {
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @GetMapping(path = "/findByName", consumes = "application/json")
    public ResponseEntity<Iterable<Person>> getPerson(@RequestBody Contact contact) {
        List<Contact> contacts = contactRepository.findByContactContaining(contact.getContact());
        List<Person> people = new ArrayList<>();
        for (Contact c : contacts) {
            people.add(c.getPerson());
        }
        return ResponseEntity.ok(people);
    }

    @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody ContactDTO contact) {
        if(!ContactValidator.validate(contact)){
            return ResponseEntity.status(HttpStatus.ACCEPTED.BAD_REQUEST).body(null);
        }
        Optional<Person> oPerson = peopleRepository.findById(contact.getId());
        if(oPerson.isPresent()) {
            Person person = oPerson.get();
            Contact newContact = new Contact(person, contact.getContactType(), contact.getContact());
            contactRepository.save(newContact);
            person.getContacts().add(newContact);
            peopleRepository.save(person);
        }
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Contact> oContact = contactRepository.findById(id);
        if (oContact.isPresent()) {
            contactRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
