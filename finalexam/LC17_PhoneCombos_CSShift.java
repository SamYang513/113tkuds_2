import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LC17_PhoneCombos_CSShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入數字字串
        String digits = scanner.nextLine();

        // 計算所有可能的字母組合
        List<String> combinations = letterCombinations(digits);

        // 輸出結果
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // 如果輸入為空，直接返回空列表
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // 定義電話鍵盤的數字到字母的映射
        String[] mapping = {
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

        // 使用回溯法生成所有組合
        backtrack(result, new StringBuilder(), digits, 0, mapping);

        return result;
    }

    private static void backtrack(List<String> result, StringBuilder combination, String digits, int index, String[] mapping) {
        // 如果組合長度等於輸入數字長度，加入結果
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // 獲取當前數字對應的字母
        String letters = mapping[digits.charAt(index) - '0'];

        // 遍歷每個字母，遞迴生成組合
        for (char letter : letters.toCharArray()) {
            combination.append(letter); // 添加字母
            backtrack(result, combination, digits, index + 1, mapping); // 遞迴
            combination.deleteCharAt(combination.length() - 1); // 回溯
        }
    }
}