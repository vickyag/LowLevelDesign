import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

    public Object[] toArray(){
        List<Integer> l = new ArrayList<>();
        ListNode root = this;
        while(root != null){
            l.add(root.val);
            root = root.next;
        }
        return l.toArray();
    }
}
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null, lastNode = null;
        while(l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            if(result == null){
                result = new ListNode(val);
                lastNode = result;
            }else{
                lastNode.next = new ListNode(val);
                lastNode = lastNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null) l1 = l2;
        while(l1 != null){
            int val1 = l1.val;
            int sum = val1 + carry;
            int val = sum % 10;
            carry = sum / 10;
            if(result == null){
                result = new ListNode(val);
                lastNode = result;
            }else{
                lastNode.next = new ListNode(val);
                lastNode = lastNode.next;
            }
            l1 = l1.next;
        }

        if(carry != 0) lastNode.next = new ListNode(carry);

        return result;
    }

    public static void main(String... s){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2); // 342 + 95 = 437
        System.out.println(Arrays.toString(result.toArray()));
    }
}
