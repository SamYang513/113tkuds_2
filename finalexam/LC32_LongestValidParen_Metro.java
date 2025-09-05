import java.util.Scanner;
import java.util.Stack;

public class LC32_LongestValidParen_Metro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入字串
        String s = scanner.nextLine();

        // 計算最長合法括號子字串長度
        int maxLength = longestValidParentheses(s);

        // 輸出結果
        System.out.println(maxLength);
    }

    public static int longestValidParentheses(String s) {
        // 使用堆疊來存儲索引
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // 初始化棧底為 -1，作為基準

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 遇到 '('，將索引壓入堆疊
                stack.push(i);
            } else {
                // 遇到 ')'，彈出堆疊
                stack.pop();

                if (stack.isEmpty()) {
                    // 如果堆疊為空，將當前索引作為新的基準
                    stack.push(i);
                } else {
                    // 計算當前合法子字串的長度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}