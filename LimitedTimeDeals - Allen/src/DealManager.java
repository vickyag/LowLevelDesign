import DealStrategy.DealClaimStrategy;
import entity.Deal;
import entity.Item;
import entity.Seller;
import entity.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class DealManager {

    private HashMap<Long, Deal> deals;
    private DealClaimStrategy dealClaimStrategy;

    private static DealManager instance;

    private DealManager(DealClaimStrategy dealClaimStrategy){
        this.deals = new HashMap<>();
        this.dealClaimStrategy = dealClaimStrategy;
    }
    public static synchronized DealManager getInstance(DealClaimStrategy dealClaimStrategy){
        if(instance == null){
            instance = new DealManager(dealClaimStrategy);
        }
        return instance;
    }

    public long createDeal(User user, int price, int noOfItems, LocalDateTime endTime) throws IllegalAccessException {
        if(!(user instanceof Seller)) throw new IllegalAccessException("User does not have access");
        HashSet<Item> items = new HashSet<>();
        while(noOfItems > 0){
            items.add(new Item("item" + noOfItems, price));
            noOfItems--;
        }
        Deal deal = new Deal(items, price, endTime, user);
        deals.put(deal.getId(), deal);
        return deal.getId();
    }

    public void endDeal(User user, long dealId) throws IllegalAccessException {
        if(!(user instanceof Seller)) throw new IllegalAccessException("User does not have access");
        Deal deal = deals.getOrDefault(dealId, null);
        if(deal == null){
            System.out.println("No deal found");
            return;
        }
        if(!user.equals(deal.getCreateBy())) throw new IllegalAccessException("User does not have access");
        deal.setActive(false);
    }

    public void updateDeal(User user, long dealId, int uNoOfItems, LocalDateTime uEndTime) throws IllegalAccessException {
        if(!(user instanceof Seller)) throw new IllegalAccessException("User does not have access");
        Deal deal = deals.getOrDefault(dealId, null);
        if(deal == null){
            System.out.println("No deal found");
            return;
        }
        if(!user.equals(deal.getCreateBy())) throw new IllegalAccessException("User does not have access");
        if(deal.getItems().size() < uNoOfItems){
            while(deal.getItems().size() != uNoOfItems){
                deal.getItems().add(new Item("item" + deal.getItems().size(), deal.getDealPrice()));
            }
        }
        else{
            Iterator<Item> it = deal.getItems().iterator();
            while(deal.getItems().size() != uNoOfItems){
                deal.getItems().remove(it.next());
            }
        }
        deal.setEndTime(uEndTime);
    }

    public void updateDeal(User user, long dealId, int uNoOfItems) throws IllegalAccessException {
        if(!(user instanceof Seller)) throw new IllegalAccessException("User does not have access");
        Deal deal = deals.getOrDefault(dealId, null);
        if(deal == null){
            System.out.println("No deal found");
            return;
        }
        if(!user.equals(deal.getCreateBy())) throw new IllegalAccessException("User does not have access");
        if(deal.getItems().size() < uNoOfItems){
            while(deal.getItems().size() != uNoOfItems){
                deal.getItems().add(new Item("item" + deal.getItems().size(), deal.getDealPrice()));
            }
        }
        else{
            Iterator<Item> it = deal.getItems().iterator();
            while(deal.getItems().size() != uNoOfItems){
                deal.getItems().remove(it.next());
            }
        }
    }

    public void updateDeal(User user, long dealId, LocalDateTime uEndTime) throws IllegalAccessException {
        if(!(user instanceof Seller)) throw new IllegalAccessException("User does not have access");
        Deal deal = deals.getOrDefault(dealId, null);
        if(deal == null){
            System.out.println("No deal found");
            return;
        }
        if(!user.equals(deal.getCreateBy())) throw new IllegalAccessException("User does not have access");
        deal.setEndTime(uEndTime);
    }

    public Item claimDeal(User user, long dealId){
        Deal deal = deals.getOrDefault(dealId, null);
        if(deal == null){
            System.out.println("No deal found");
            return null;
        }
        Item item = this.dealClaimStrategy.claimDeal(user, deal);
        if(item == null) System.out.println("Deal cannot be claimed");
        return item;
    }

    public HashMap<Long, Deal> getDeals() {
        return deals;
    }

    @Override
    public String toString() {
        return "DealManager{" +
                "deals=" + deals +
                '}';
    }
}
