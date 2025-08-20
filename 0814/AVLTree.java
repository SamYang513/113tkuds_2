public class AVLTree {
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

    // 中序遍歷
    public void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // 插入節點
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        // 中序遍歷輸出
        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder(tree.root);
    }
}