package hu.elte.WorkplaceContactsBackend.lib;

import hu.elte.WorkplaceContactsBackend.DTO.ContactDTO;
import hu.elte.WorkplaceContactsBackend.entities.Contact;
import java.util.regex.*;
/**
 *
 * @author Alex
 */
public class ContactValidator {
    
    static public boolean validate(ContactDTO contact){
        switch (contact.getContactType()){
            case TELEPHONE:
                return validateTelephone(contact);
            case MOBILE_PHONE:
                return validateMobilePhone(contact);
            case EMAIL:
                return validateEmail(contact);
            default:
                return false;
        }
    }
    
    static public boolean validateEmail(ContactDTO contact){
        boolean valid = Pattern.matches(
                "^[A-ZÖÜÓŐÚÁŰ0-9a-zöüóőúáű._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"
                , contact.getContact().trim());
        return valid;
    }
    
    static public boolean validateMobilePhone(ContactDTO contact){
        boolean valid = Pattern.matches(
                "^[+]?[0-9 ]{6,20}"
                , contact.getContact().trim());
        return valid;
    }
    
    static public boolean validateTelephone(ContactDTO contact){
        boolean valid = Pattern.matches(
                "^[+]?[0-9 ]{6,20}"
                , contact.getContact().trim());
        return valid;
    }
}
