package search.strategy;

import entity.AddressBook;
import entity.Contact;

import java.util.List;

public class SearchByFirstNameStrategy implements SearchStrategy{

    private final AddressBook addressBook;

    public SearchByFirstNameStrategy(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
    @Override
    public List<Contact> search(String searchString) {
        return addressBook.getContactsByName().getOrDefault(searchString, null);
    }
}
