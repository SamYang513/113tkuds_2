public class It_10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] 表示 s 的前 i 個字符是否能與 p 的前 j 個字符匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 空字串與空模式匹配
        dp[0][0] = true;

        // 處理 p 中的 '*'，使其能匹配空字串
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填充 dp 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    // 當字符匹配或模式為 '.' 時
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // 當模式為 '*' 時
                    dp[i][j] = dp[i][j - 2]; // '*' 匹配零次
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // '*' 匹配一次或多次
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        It_10_RegularExpressionMatching solution = new It_10_RegularExpressionMatching();

        // 測試案例 1
        String s1 = "aa", p1 = "a";
        System.out.println("Input: s = " + s1 + ", p = " + p1);
        System.out.println("Output: " + solution.isMatch(s1, p1)); // false

        // 測試案例 2
        String s2 = "aa", p2 = "a*";
        System.out.println("Input: s = " + s2 + ", p = " + p2);
        System.out.println("Output: " + solution.isMatch(s2, p2)); // true

        // 測試案例 3
        String s3 = "ab", p3 = ".*";
        System.out.println("Input: s = " + s3 + ", p = " + p3);
        System.out.println("Output: " + solution.isMatch(s3, p3)); // true
    }
}