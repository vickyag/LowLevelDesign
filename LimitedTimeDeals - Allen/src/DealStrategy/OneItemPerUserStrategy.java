package DealStrategy;

import entity.Deal;
import entity.Item;
import entity.User;

import java.time.LocalDateTime;
import java.util.Iterator;

public class OneItemPerUserStrategy implements DealClaimStrategy{
    @Override
    public Item claimDeal(User user, Deal deal) {
        if(!deal.isActive()) return null;
        if(deal.getItems().isEmpty()) return null;
        if(deal.getEndTime().isBefore(LocalDateTime.now())) return null;
        if(deal.getItemSold().containsKey(user)) return null;

        Iterator<Item> it = deal.getItems().iterator();
        Item item = it.next();
        deal.getItemSold().put(user, item);
        deal.getItems().remove(item);
        return item;
    }
}
