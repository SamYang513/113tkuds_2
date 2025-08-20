public class AVLRotationExercise {
    static class AVLNode {
        int data;
        AVLNode left, right;
        int height;

        public AVLNode(int data) {
            this.data = data;
            this.height = 1;
        }

        // 更新節點高度
        public void updateHeight() {
            int leftHeight = (left != null) ? left.height : 0;
            int rightHeight = (right != null) ? right.height : 0;
            this.height = Math.max(leftHeight, rightHeight) + 1;
        }

        // 計算平衡因子
        public int getBalance() {
            int leftHeight = (left != null) ? left.height : 0;
            int rightHeight = (right != null) ? right.height : 0;
            return leftHeight - rightHeight;
        }
    }

    // 左旋操作
    public static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // 執行旋轉
        y.left = x;
        x.right = T2;

        // 更新高度
        x.updateHeight();
        y.updateHeight();

        return y; // 新的根節點
    }

    // 右旋操作
    public static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // 執行旋轉
        x.right = y;
        y.left = T2;

        // 更新高度
        y.updateHeight();
        x.updateHeight();

        return x; // 新的根節點
    }

    // 左右旋操作
    public static AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    // 右左旋操作
    public static AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public static void main(String[] args) {
        // 測試左旋
        System.out.println("Testing Left Rotation:");
        AVLNode root = new AVLNode(10);
        root.right = new AVLNode(20);
        root.right.right = new AVLNode(30);
        root.updateHeight();
        root.right.updateHeight();
        root = leftRotate(root);
        System.out.println("Root after left rotation: " + root.data); // 20

        // 測試右旋
        System.out.println("\nTesting Right Rotation:");
        root = new AVLNode(30);
        root.left = new AVLNode(20);
        root.left.left = new AVLNode(10);
        root.updateHeight();
        root.left.updateHeight();
        root = rightRotate(root);
        System.out.println("Root after right rotation: " + root.data); // 20

        // 測試左右旋
        System.out.println("\nTesting Left-Right Rotation:");
        root = new AVLNode(30);
        root.left = new AVLNode(10);
        root.left.right = new AVLNode(20);
        root.updateHeight();
        root.left.updateHeight();
        root = leftRightRotate(root);
        System.out.println("Root after left-right rotation: " + root.data); // 20

        // 測試右左旋
        System.out.println("\nTesting Right-Left Rotation:");
        root = new AVLNode(10);
        root.right = new AVLNode(30);
        root.right.left = new AVLNode(20);
        root.updateHeight();
        root.right.updateHeight();
        root = rightLeftRotate(root);
        System.out.println("Root after right-left rotation: " + root.data); // 20
    }
}