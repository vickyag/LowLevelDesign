package search.strategy;

import entity.Contact;

import java.util.List;

public interface SearchStrategy {
    List<Contact> search(String searchString);
}
