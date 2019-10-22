/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.keys;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import java.io.Serializable;

/**
 *
 * @author Attila
 */
public class ContactKey implements Serializable  {
    private Person person;
    private ContactType contactType;
    private String contact;
    
    
    public enum ContactType {
        TELEPHONE, MOBILE_PHONE, EMAIL
    }
}


