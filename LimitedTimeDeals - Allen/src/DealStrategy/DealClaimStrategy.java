package DealStrategy;

import entity.Deal;
import entity.Item;
import entity.User;

public interface DealClaimStrategy {
    Item claimDeal(User user, Deal deal);
}
