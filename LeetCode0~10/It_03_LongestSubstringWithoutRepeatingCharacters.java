import java.util.*;

public class It_03_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 使用 HashSet 來追蹤當前子字串中的字符
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0; // 滑動視窗的左指標

        // 遍歷字串
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果當前字符已存在於集合中，移動左指標並移除字符
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // 將當前字符加入集合
            set.add(currentChar);

            // 更新最大長度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        It_03_LongestSubstringWithoutRepeatingCharacters solution = new It_03_LongestSubstringWithoutRepeatingCharacters();

        // 測試案例 1
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s1)); // 3

        // 測試案例 2
        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s2)); // 1

        // 測試案例 3
        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s3)); // 3
    }
}