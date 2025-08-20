public class AVLRotations {
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

    public static void main(String[] args) {
        // 建立節點
        AVLNode root = new AVLNode(10);
        root.left = new AVLNode(5);
        root.right = new AVLNode(20);
        root.right.left = new AVLNode(15);
        root.right.right = new AVLNode(25);

        // 更新節點高度
        root.right.updateHeight();
        root.updateHeight();

        System.out.println("Before Left Rotation:");
        System.out.println("Root: " + root.data);
        System.out.println("Root Height: " + root.height);

        // 左旋操作
        root = leftRotate(root);

        System.out.println("\nAfter Left Rotation:");
        System.out.println("Root: " + root.data);
        System.out.println("Root Height: " + root.height);

        // 右旋操作
        root = rightRotate(root);

        System.out.println("\nAfter Right Rotation:");
        System.out.println("Root: " + root.data);
        System.out.println("Root Height: " + root.height);
    }
}

class AVLNode {
    int data;
    AVLNode left, right;
    int height;

    public AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }

    // 計算平衡因子
    public int getBalance() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }

    // 更新節點高度
    public void updateHeight() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }
}