public class It_05_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        // 遍歷每個字符，將其作為回文中心
        for (int i = 0; i < s.length(); i++) {
            // 回文中心為單個字符
            int len1 = expandAroundCenter(s, i, i);
            // 回文中心為兩個字符
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            // 更新最長回文子字串的起始和結束位置
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 中心擴展法
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 回文子字串的長度
    }

    public static void main(String[] args) {
        It_05_LongestPalindromicSubstring solution = new It_05_LongestPalindromicSubstring();

        // 測試案例 1
        String s1 = "babad";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.longestPalindrome(s1)); // "bab" 或 "aba"

        // 測試案例 2
        String s2 = "cbbd";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.longestPalindrome(s2)); // "bb"
    }
}