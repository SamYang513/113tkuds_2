import java.util.ArrayList;
import java.util.List;

public class It_22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // 如果當前字串長度等於 2 * n，則加入結果
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // 如果可以加入左括號
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // 回溯
        }

        // 如果可以加入右括號
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // 回溯
        }
    }

    public static void main(String[] args) {
        It_22_GenerateParentheses solution = new It_22_GenerateParentheses();

        // 測試案例 1
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.generateParenthesis(n1));

        // 測試案例 2
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.generateParenthesis(n2));
    }
}