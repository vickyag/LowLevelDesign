class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class DPWorld {
  private int maxSum;

  public int maxPathSumWithSkip(TreeNode root) {
    if (root == null) {
      return 0;
    }
    maxSum = root.val;
    solve(root);
    return maxSum;
  }

  private int[] solve(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }

    int val = node.val;
    int[] leftResult = solve(node.left);
    int[] rightResult = solve(node.right);
    int leftNoSkip = leftResult[0];
    int leftSkip = leftResult[1];
    int rightNoSkip = rightResult[0];
    int rightSkip = rightResult[1];

    int noSkipPath = val + Math.max(0, leftNoSkip) + Math.max(0, rightNoSkip);
    int oneSkipPath = Math.max(val, Math.max(Math.max(leftSkip + Math.max(0, rightNoSkip),
                                                rightSkip + Math.max(0, leftNoSkip)),
                                     Math.max(0, leftNoSkip) + Math.max(0, rightNoSkip)));

    maxSum = Math.max(maxSum, Math.max(noSkipPath, oneSkipPath));

    int noSkipEnd = val + Math.max(0, Math.max(leftNoSkip, rightNoSkip));
    int oneSkipEnd = Math.max(val + Math.max(leftSkip, rightNoSkip), val + Math.max(leftNoSkip, rightSkip));
    oneSkipEnd = Math.max(oneSkipEnd, Math.max(0, Math.max(leftNoSkip, rightNoSkip)));

    return new int[]{noSkipEnd, oneSkipEnd};
  }

  public static void main(String[] args) {
    TreeNode root2 = new TreeNode(-1);
    root2.left = new TreeNode(-2);
    root2.right = new TreeNode(-3);
    root2.right.left = new TreeNode(-5);
    root2.right.right = new TreeNode(4);
    DPWorld sol2 = new DPWorld();
    System.out.println("Maximum path sum with skip in Example 2: " + sol2.maxPathSumWithSkip(root2));
  }
}

//ashok.geekgupta@gmail.com



