import java.util.*;

class CryptoOrders {

    private static int solve(int[][] orders){

        Comparator<int[]> sellComp = (a, b) -> {
            return a[0] - b[0];
        };
        Comparator<int[]> buyComp = (a, b) -> {
            return b[0] - a[0];
        };
        Queue<int[]> buyBacklog = new PriorityQueue<>(buyComp);
        Queue<int[]> sellBacklog = new PriorityQueue<>(sellComp);

        for(int [] order: orders){
            int price = order[0];
            int unit = order[1];
            int oType = order[2];

            if(oType == 0){
                while(!sellBacklog.isEmpty() && price >= sellBacklog.peek()[0]){
                    int[] smallestSellOrder = sellBacklog.poll();
                    int sPrice = smallestSellOrder[0];
                    int sUnit = smallestSellOrder[1];
                    if(sPrice <= price ){
                        int temp = unit;
                        unit = unit - sUnit;
                        sUnit = sUnit - temp;
                    }
                    if(sUnit > 0){
                        smallestSellOrder[1] = sUnit;
                        sellBacklog.offer(smallestSellOrder);
                    }
                    if(unit > 0){
                        order[1] = unit;
                    }else{
                        break;
                    }
                }
                if(unit > 0){
                    buyBacklog.offer(order);
                }
            }else{
                while(!buyBacklog.isEmpty() && price <= buyBacklog.peek()[0]){
                    int[] largestBuyOrder = buyBacklog.poll();
                    int bPrice = largestBuyOrder[0];
                    int bUnit = largestBuyOrder[1];
                    if(bPrice >= price ){
                        int temp = unit;
                        unit = unit - bUnit;
                        bUnit = bUnit - temp;
                    }
                    if(bUnit > 0){
                        largestBuyOrder[1] = bUnit;
                        buyBacklog.offer(largestBuyOrder);
                    }
                    if(unit > 0){
                        order[1] = unit;
                    }else{
                        break;
                    }
                }
                if(unit > 0){
                    sellBacklog.offer(order);
                }
            }
        }

        int totalUnitLeft = 0;
        while(!buyBacklog.isEmpty()){
            int[] polledOrder = buyBacklog.poll();
            totalUnitLeft += polledOrder[1];
        }
        while(!sellBacklog.isEmpty()){
            int[] polledOrder = sellBacklog.poll();
            totalUnitLeft += polledOrder[1];
        }

        return totalUnitLeft;
    }



    public static void main(String... s){
        int[][] orders = new int[][]{{10,3,0},{10,2,0},{15,1,1},{25,2,1},{30,4,0},{9,6,1}};
        System.out.println(solve(orders));

    }

}
