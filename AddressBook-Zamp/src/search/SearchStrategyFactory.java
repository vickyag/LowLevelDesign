package search;

import entity.AddressBook;
import constant.SearchCriteria;
import search.strategy.SearchStrategy;

public interface SearchStrategyFactory {
    SearchStrategy getSearchStrategy(SearchCriteria searchCriteria, AddressBook addressBook);
}
