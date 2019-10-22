package hu.elte.WorkplaceContactsBackend.repositories;

import hu.elte.WorkplaceContactsBackend.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository  extends CrudRepository<Contact, Integer> {
    
}
