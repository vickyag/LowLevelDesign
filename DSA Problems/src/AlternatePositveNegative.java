import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlternatePositveNegative {


    public static void main(String... s){

        int[] in = new int[]{2, -3, 4, 5, -9, -1, -6, 8};
        int n = in.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int posIdx = 0, negIdx = 0;
        boolean isEven = true;
        for(int i: in){
            if(i < 0) neg.add(i);
            else pos.add(i);
        }

        while(posIdx < pos.size() && negIdx < neg.size()){
            if(isEven){
                op.add(neg.get(negIdx));
                negIdx++;
            }else {
                op.add(pos.get(posIdx));
                posIdx++;
            }
            isEven = !isEven;
        }

        while(posIdx < pos.size()){
            op.add(pos.get(posIdx));
            posIdx++;
        }

        while(negIdx < neg.size()){
            op.add(neg.get(negIdx));
            negIdx++;
        }
        System.out.println(op);
    }

}
