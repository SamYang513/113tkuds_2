import java.util.*;

public class M08_BSTRangedSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取節點數量
        int n = Integer.parseInt(scanner.nextLine());
        int[] values = Arrays.stream(scanner.nextLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        // 讀取區間 [L, R]
        String[] range = scanner.nextLine().split(" ");
        int L = Integer.parseInt(range[0]);
        int R = Integer.parseInt(range[1]);

        // 建立二元搜尋樹
        TreeNode root = buildTree(values);

        // 計算區間內的鍵值和
        int sum = rangeSumBST(root, L, R);

        // 輸出結果
        System.out.println("Sum: " + sum);

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

    // 建立二元搜尋樹（層序，-1 表示 null）
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

    // 計算區間內的鍵值和
    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // 如果節點值在區間內，加入到總和
        if (L <= root.val && root.val <= R) {
            sum += root.val;
        }

        // 如果節點值大於 L，遞迴處理左子樹
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }

        // 如果節點值小於 R，遞迴處理右子樹
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }
}