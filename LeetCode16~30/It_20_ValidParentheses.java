import java.util.Stack;

public class It_20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是開括號，將其壓入堆疊
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 如果是閉括號，檢查堆疊是否為空或是否匹配
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 如果堆疊為空，則括號有效
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        It_20_ValidParentheses solution = new It_20_ValidParentheses();

        // 測試案例 1
        String s1 = "()";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.isValid(s1)); // true

        // 測試案例 2
        String s2 = "()[]{}";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.isValid(s2)); // true

        // 測試案例 3
        String s3 = "(]";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.isValid(s3)); // false

        // 測試案例 4
        String s4 = "([])";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.isValid(s4)); // true

        // 測試案例 5
        String s5 = "([)]";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + solution.isValid(s5)); // false
    }
}