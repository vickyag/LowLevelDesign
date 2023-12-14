package service;

import entity.AddressBook;
import entity.Contact;
import constant.SearchCriteria;
import search.strategy.SearchStrategy;
import search.SearchStrategyFactory;

import java.util.List;

public class AddressBookService {

    private static AddressBookService instance;
    private AddressBook addressBook;
    private SearchStrategyFactory searchStrategyFactory;

    private AddressBookService(AddressBook addressBook, SearchStrategyFactory searchStrategyFactory) {
        this.addressBook = addressBook;
        this.searchStrategyFactory = searchStrategyFactory;
    }

    public static synchronized AddressBookService getInstance(AddressBook addressBook,
                                                              SearchStrategyFactory searchStrategyFactory){
        if(instance == null){
            instance = new AddressBookService(addressBook, searchStrategyFactory);
        }
        return instance;
    }

    public void addContact(Contact contact){
        this.addressBook.addContact(contact);
    }

    public List<Contact> searchContacts(SearchCriteria searchCriteria, String searchString){
        SearchStrategy searchStrategy = this.searchStrategyFactory.getSearchStrategy(searchCriteria, this.addressBook);
        return searchStrategy.search(searchString);
    }

    // Getters - Setters
    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public SearchStrategyFactory getSearchStrategyFactory() {
        return searchStrategyFactory;
    }

    public void setSearchStrategyFactory(SearchStrategyFactory searchStrategyFactory) {
        this.searchStrategyFactory = searchStrategyFactory;
    }
}
