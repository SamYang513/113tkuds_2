import java.util.*;

public class M09_AVLValidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取節點數量
        int n = Integer.parseInt(scanner.nextLine());
        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        // 建立二元樹
        TreeNode root = buildTree(values);

        // 檢查是否為 BST 和 AVL
        if (!isBST(root, null, null)) {
            System.out.println("Invalid BST");
        } else if (!isAVL(root)) {
            System.out.println("Invalid AVL");
        } else {
            System.out.println("Valid");
        }

        scanner.close();
    }

    // 定義二元樹節點類別
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 建立二元樹（層序，-1 表示 null）
    private static TreeNode buildTree(int[] values) {
        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();

            // 建立左子節點
            if (i < values.length && values[i] != -1) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // 建立右子節點
            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // 檢查是否為 BST
    private static boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // 節點值必須在 (min, max) 範圍內
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // 遞迴檢查左子樹與右子樹
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }

    // 檢查是否為 AVL
    private static boolean isAVL(TreeNode node) {
        return checkHeight(node) != -1;
    }

    // 檢查樹的高度，同時判斷是否符合 AVL 條件
    private static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        // 如果子樹不平衡，返回 -1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 返回當前節點的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}