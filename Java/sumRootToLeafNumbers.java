

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class sumRootToLeafNums {
    private static int sum = 0;

    public void getSum(TreeNode node, int num) {
        if (node == null) return;
        num = num * 10 + node.val;
        if (node.left == null && node.right == null)
            sum += num;
        else {
            getSum(node.left, num);
            getSum(node.right, num);
        }
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        this.getSum(root, 0);
        return sum;
    }
}