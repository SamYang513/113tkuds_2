public class AVLDeleteExercise {
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

    // 刪除節點
    public AVLNode delete(AVLNode node, int data) {
        if (node == null) {
            return node;
        }

        // 遍歷樹找到要刪除的節點
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // 節點為葉子節點或只有一個子節點
            if (node.left == null || node.right == null) {
                AVLNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    node = null; // 刪除葉子節點
                } else {
                    node = temp; // 刪除只有一個子節點的節點
                }
            } else {
                // 節點有兩個子節點，找後繼節點
                AVLNode temp = getMinValueNode(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }

        if (node == null) {
            return node;
        }

        // 更新高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        // 檢查平衡並進行旋轉
        int balance = getBalance(node);

        // 左左情況
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        // 左右情況
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // 右右情況
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // 右左情況
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 找到最小值節點（後繼節點）
    private AVLNode getMinValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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
        AVLDeleteExercise tree = new AVLDeleteExercise();

        // 插入節點
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("In-order traversal before deletion:");
        tree.inOrder(tree.root);

        // 刪除葉子節點
        System.out.println("\n\nDeleting leaf node 20:");
        tree.root = tree.delete(tree.root, 20);
        tree.inOrder(tree.root);

        // 刪除只有一個子節點的節點
        System.out.println("\n\nDeleting node 30 (has one child):");
        tree.root = tree.delete(tree.root, 30);
        tree.inOrder(tree.root);

        // 刪除有兩個子節點的節點
        System.out.println("\n\nDeleting node 50 (has two children):");
        tree.root = tree.delete(tree.root, 50);
        tree.inOrder(tree.root);
    }
}