import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入字串
        String s = scanner.nextLine();

        // 驗證括號是否正確配對
        boolean isValid = isValidParentheses(s);

        // 輸出結果
        System.out.println(isValid);
    }

    public static boolean isValidParentheses(String s) {
        // 如果字串為空，直接返回 true
        if (s == null || s.isEmpty()) {
            return true;
        }

        // 建立閉括號到開括號的對應表
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');

        // 使用堆疊來檢查括號配對
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是閉括號，檢查是否匹配棧頂
            if (matchingBrackets.containsKey(c)) {
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != matchingBrackets.get(c)) {
                    return false; // 不匹配，返回 false
                }
            } else {
                // 如果是開括號，壓入堆疊
                stack.push(c);
            }
        }

        // 如果堆疊為空，表示所有括號都匹配
        return stack.isEmpty();
    }
}