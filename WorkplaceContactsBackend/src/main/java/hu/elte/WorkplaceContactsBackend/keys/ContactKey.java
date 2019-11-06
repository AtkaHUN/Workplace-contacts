package hu.elte.WorkplaceContactsBackend.keys;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContactKey implements Serializable  {
    private Person person;
    private ContactType contactType;
    private String contact;
    
    
    public enum ContactType {
        TELEPHONE, MOBILE_PHONE, EMAIL
    }
}


