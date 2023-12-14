import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IterativePostOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void postOrder(TreeNode root){
        Map<TreeNode, Integer> mp = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();

        if(root == null) return;
        s.push(root);
        mp.put(root, 0);

        while(!s.isEmpty()){
            TreeNode node = s.peek();

            if(mp.get(node) == 0){  // map value 0 represents 1st line in recursive approach for postorder traversal
                if(node.left != null) {
                    s.push(node.left);
                    mp.put(node.left, 0);
                }
            }
            else if(mp.get(node) == 1) {    // map value 1 represents 2nd line in recursive approach for postorder traversal
                if(node.right != null){
                    s.push(node.right);
                    mp.put(node.right, 0);
                }
            }
            else if(mp.get(node) == 2){     // map value 2 represents 3rd line in recursive approach for postorder traversal
                System.out.print(node.val + ",");
            }
            else {
                s.pop();
                continue;
            }
            mp.put(node, mp.get(node) + 1);
        }
    }
}
