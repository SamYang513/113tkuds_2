import java.util.*;

public class M07_BinaryTreeLeftView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取節點數量
        int n = Integer.parseInt(scanner.nextLine());
        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        // 建立二元樹
        TreeNode root = buildTree(values);

        // 計算左視圖
        List<Integer> leftView = getLeftView(root);

        // 輸出結果
        System.out.print("LeftView: ");
        for (int val : leftView) {
            System.out.print(val + " ");
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

    // 計算二元樹的左視圖
    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> leftView = new ArrayList<>();
        if (root == null) {
            return leftView;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // 每層的第一個節點即為左視圖節點
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (i == 0) {
                    leftView.add(current.val);
                }

                // 加入子節點到佇列
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return leftView;
    }
}