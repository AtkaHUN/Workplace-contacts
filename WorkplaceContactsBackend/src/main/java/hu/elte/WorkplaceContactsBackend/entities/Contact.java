package hu.elte.WorkplaceContactsBackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Person person;
    
    @Column(name = "contact_type")
    private ContactType contactType;
    
    @Column
    private String contact;

    public Contact(Person person, ContactType contactType, String contact) {
        this.person = person;
        this.contactType = contactType;
        this.contact = contact;
    }
    
    
    public enum ContactType {
        TELEPHONE, MOBILE_PHONE, EMAIL
    }
}
