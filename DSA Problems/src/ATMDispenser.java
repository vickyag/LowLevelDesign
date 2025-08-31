import java.util.HashMap;
import java.util.Map;

class ATMDispenser{

    private Map<Integer, Integer> denominations;
    public static final int ATM_LIMIT = 40000;
    private Integer ATMBalance = 0;
    private int[] denominationType = new int[]{500, 200, 100};

    public ATMDispenser(Map<Integer, Integer> denominations){
        this.denominations = denominations;
        for(int key : denominations.keySet()){
            ATMBalance += key * denominations.get(key);
        }
    }

    private void display(String msg){
        System.out.println(msg);
    }

    public void refillATM(Map<Integer, Integer> refill){
        for(int key : refill.keySet()){
            denominations.putIfAbsent(key, 0);
            denominations.put(key, denominations.get(key) + refill.get(key));
            ATMBalance += key * refill.get(key);
        }
        display("Load success");
    }



    public boolean getAmount(int amount) {
        if (amount > ATM_LIMIT) {
            display("The amount exceeds ATM withdrawl limit");
            return false;
        }
//        if(checkBalance() - minAmount() < amount){
//            display(" The User doesn't have sufficient balance in bank account");
//            return false;
//        }
        if(ATMBalance < amount){
            display("ATM does not have that much balance to dispense");
            return false;
        }

        int[] count = new int[denominationType.length];
        int indx = 0;
        for (int den : denominationType) {
            int temp = amount / den;
            if (temp <= denominations.get(den)) {
                count[indx++] = temp;
                amount %= den;
            } else {
                count[indx++] = denominations.get(den);
                amount -= denominations.get(den) * den;
            }
        }
        if (amount == 0) {
            display("500 : " + count[0] + " 200 : " + count[1] + " 100 : " + count[2]);
            int idx = 0;
            for(int den : denominationType){
                ATMBalance -= count[idx++] * den;
                denominations.put(den, denominations.get(den) - count[idx-1]);
            }
            display("ATM Balance " + ATMBalance);
            return true;
        }
        display("ATM cannot dispense the amount");
        display("ATM Balance " + ATMBalance);
        return false;

    }

    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(500, 40);
        map.put(200, 100);
        map.put(100, 100);
        ATMDispenser dispenser = new ATMDispenser(map);
        dispenser.getAmount(40000);
        dispenser.getAmount(40000);
        dispenser.getAmount(3002);
        dispenser.getAmount(10000);
        dispenser.getAmount(100);
    }

}