import java.util.ArrayList;
import java.util.List;

public class It_17_LetterCombinationsOfAPhoneNumber {
    // 數字到字母的映射
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result; // 如果輸入為空，返回空列表
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    // 回溯法
    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter); // 添加當前字母
            backtrack(result, combination, digits, index + 1); // 遞歸處理下一個數字
            combination.deleteCharAt(combination.length() - 1); // 回溯，移除最後一個字母
        }
    }

    public static void main(String[] args) {
        It_17_LetterCombinationsOfAPhoneNumber solution = new It_17_LetterCombinationsOfAPhoneNumber();

        // 測試案例 1
        String digits1 = "23";
        System.out.println("Input: " + digits1);
        System.out.println("Output: " + solution.letterCombinations(digits1)); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        // 測試案例 2
        String digits2 = "";
        System.out.println("Input: " + digits2);
        System.out.println("Output: " + solution.letterCombinations(digits2)); // []

        // 測試案例 3
        String digits3 = "2";
        System.out.println("Input: " + digits3);
        System.out.println("Output: " + solution.letterCombinations(digits3)); // ["a","b","c"]
    }
}