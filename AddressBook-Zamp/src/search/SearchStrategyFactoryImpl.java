package search;

import entity.AddressBook;
import constant.SearchCriteria;
import search.strategy.SearchByFirstNameStrategy;
import search.strategy.SearchByPhoneNumberStrategy;
import search.strategy.SearchStrategy;

public class SearchStrategyFactoryImpl implements SearchStrategyFactory{

    public SearchStrategyFactoryImpl() {}

    @Override
    public SearchStrategy getSearchStrategy(SearchCriteria searchCriteria, AddressBook addressBook) {
        SearchStrategy searchStrategy = null;
        switch (searchCriteria){
            case FirstName:
                searchStrategy = new SearchByFirstNameStrategy(addressBook);
                break;
            case PhoneNumber:
                searchStrategy = new SearchByPhoneNumberStrategy(addressBook);
                break;
            default:
                break;
        }
        return searchStrategy;
    }

}
