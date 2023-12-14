import DealStrategy.DealClaimStrategy;
import DealStrategy.OneItemPerUserStrategy;
import entity.Buyer;
import entity.Seller;
import entity.User;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        DealClaimStrategy dealClaimStrategy = new OneItemPerUserStrategy();
        DealManager dealManager = DealManager.getInstance(dealClaimStrategy);

        User seller1 = new Seller("Seller1");
        User buyer1 = new Buyer("Buyer1");
        User buyer2 = new Buyer("Buyer2");
        try{

            long dealId = dealManager.createDeal(seller1, 100, 2, LocalDateTime.now().plusMinutes(3));
            System.out.println(dealManager.getDeals().get(dealId));
            dealManager.updateDeal(buyer1, dealId, 3);
            System.out.println(dealManager.getDeals().get(dealId));
            dealManager.claimDeal(buyer1, dealId);
            System.out.println(dealManager.getDeals().get(dealId));
            dealManager.claimDeal(buyer1, dealId);
            System.out.println(dealManager.getDeals().get(dealId));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}