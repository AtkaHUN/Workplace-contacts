package hu.elte.WorkplaceContactsBackend.keys;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ContactKey implements Serializable  {
    private Person person;
    private ContactType contactType;
    private String contact;
    
    
    public enum ContactType {
        TELEPHONE, MOBILE_PHONE, EMAIL
    }
}


