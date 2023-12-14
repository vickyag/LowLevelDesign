package entity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AddressBook {

    private final Map<String, List<Contact>> contactsByName;
    private final Map<String, Contact> contactsByPhoneNumber;

    public AddressBook() {
        this.contactsByName = new HashMap<>();
        this.contactsByPhoneNumber = new HashMap<>();
    }

    public void addContact(Contact contact){
        String name = contact.getFirstName();
        String phoneNumber = contact.getPhoneNumber();

        // Upsert handling in contactsByName map
        if(contactsByPhoneNumber.containsKey(phoneNumber)){
            Contact oldContact = contactsByPhoneNumber.get(phoneNumber);
            List<Contact> contacts = contactsByName.get(oldContact.getFirstName());
            contacts.remove(oldContact);
        }
        if(!contactsByName.containsKey(name)){
            contactsByName.put(name, new LinkedList<>());
        }
        contactsByName.get(name).add(contact);
        contactsByPhoneNumber.put(phoneNumber, contact);
    }

    public Map<String, List<Contact>> getContactsByName() {
        return contactsByName;
    }

    public Map<String, Contact> getContactsByPhoneNumber() {
        return contactsByPhoneNumber;
    }
}
