import java.util.*;

public class M10_RBPropertiesCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取節點數量
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");

        // 建立節點陣列
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(input[2 * i]);
            char color = input[2 * i + 1].charAt(0);
            nodes[i] = new Node(value, color);
        }

        // 檢查紅黑樹性質
        String result = validateRedBlackTree(nodes);
        System.out.println(result);

        scanner.close();
    }

    // 定義節點類別
    static class Node {
        int value;
        char color; // 'B' 或 'R'

        Node(int value, char color) {
            this.value = value;
            this.color = color;
        }
    }

    // 驗證紅黑樹性質
    private static String validateRedBlackTree(Node[] nodes) {
        if (nodes.length == 0) {
            return "RB Valid";
        }

        // 檢查根節點是否為黑色
        if (nodes[0].color != 'B') {
            return "RootNotBlack";
        }

        // 檢查紅紅相鄰與黑高度一致
        if (!checkProperties(nodes, 0).isValid) {
            return checkProperties(nodes, 0).errorMessage;
        }

        return "RB Valid";
    }

    // 檢查紅黑樹性質的輔助方法
    private static Result checkProperties(Node[] nodes, int index) {
        if (index >= nodes.length || nodes[index].value == -1) {
            // 空節點視為黑色，黑高度為 1
            return new Result(true, 1, "");
        }

        Node current = nodes[index];

        // 檢查紅紅相鄰
        if (current.color == 'R') {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            if ((leftIndex < nodes.length && nodes[leftIndex].color == 'R') ||
                (rightIndex < nodes.length && nodes[rightIndex].color == 'R')) {
                return new Result(false, 0, "RedRedViolation at index " + index);
            }
        }

        // 遞迴檢查左右子樹
        Result leftResult = checkProperties(nodes, 2 * index + 1);
        Result rightResult = checkProperties(nodes, 2 * index + 2);

        // 如果子樹不合法，直接返回錯誤
        if (!leftResult.isValid) {
            return leftResult;
        }
        if (!rightResult.isValid) {
            return rightResult;
        }

        // 檢查黑高度是否一致
        if (leftResult.blackHeight != rightResult.blackHeight) {
            return new Result(false, 0, "BlackHeightMismatch");
        }

        // 計算當前節點的黑高度
        int blackHeight = leftResult.blackHeight + (current.color == 'B' ? 1 : 0);

        return new Result(true, blackHeight, "");
    }

    // 定義檢查結果類別
    static class Result {
        boolean isValid;
        int blackHeight;
        String errorMessage;

        Result(boolean isValid, int blackHeight, String errorMessage) {
            this.isValid = isValid;
            this.blackHeight = blackHeight;
            this.errorMessage = errorMessage;
        }
    }
}