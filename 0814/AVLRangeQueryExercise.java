import java.util.*;

public class AVLRangeQueryExercise {
    class AVLNode {
        int data;
        AVLNode left, right;
        int height;

        public AVLNode(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private AVLNode root;

    // 計算節點高度
    private int getHeight(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    // 計算平衡因子
    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // 左旋操作
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // 右旋操作
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 插入節點
    public AVLNode insert(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node; // 不允許重複值
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balance = getBalance(node);

        // 左左情況
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // 右右情況
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // 左右情況
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 右左情況
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 範圍查詢
    public List<Integer> rangeQuery(int min, int max) {
        List<Integer> result = new ArrayList<>();
        rangeQueryHelper(root, min, max, result);
        return result;
    }

    private void rangeQueryHelper(AVLNode node, int min, int max, List<Integer> result) {
        if (node == null) {
            return;
        }

        // 如果節點值大於 min，遞迴左子樹
        if (node.data > min) {
            rangeQueryHelper(node.left, min, max, result);
        }

        // 如果節點值在範圍內，加入結果
        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }

        // 如果節點值小於 max，遞迴右子樹
        if (node.data < max) {
            rangeQueryHelper(node.right, min, max, result);
        }
    }

    // 中序遍歷
    public void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLRangeQueryExercise tree = new AVLRangeQueryExercise();

        // 插入節點
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("In-order traversal:");
        tree.inOrder(tree.root);

        // 範圍查詢
        System.out.println("\n\nRange Query [30, 70]:");
        List<Integer> result = tree.rangeQuery(30, 70);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}