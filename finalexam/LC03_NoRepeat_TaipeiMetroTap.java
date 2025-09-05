import java.util.HashMap;
import java.util.Scanner;

public class LC03_NoRepeat_TaipeiMetroTap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入字串
        String s = scanner.nextLine();

        // 計算最長不含重複字元子字串的長度
        int maxLength = lengthOfLongestSubstring(s);

        // 輸出結果
        System.out.println(maxLength);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 使用 HashMap 記錄每個字元的最後出現位置
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0; // 滑動視窗的左指針

        // 遍歷字串
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果當前字元已存在於 map 中，更新左指針
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // 更新當前字元的最後出現位置
            map.put(currentChar, right);

            // 計算當前視窗的長度，並更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}