package search.strategy;

import entity.AddressBook;
import entity.Contact;

import java.util.LinkedList;
import java.util.List;

public class SearchByPhoneNumberStrategy implements SearchStrategy{

    private final AddressBook addressBook;

    public SearchByPhoneNumberStrategy(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public List<Contact> search(String searchString) {
        Contact foundContact = addressBook.getContactsByPhoneNumber().getOrDefault(searchString, null);
        List<Contact> searchResult = null;
        if(foundContact != null){
            searchResult = new LinkedList<>();
            searchResult.add(foundContact);
        }
        return searchResult;
    }
}
