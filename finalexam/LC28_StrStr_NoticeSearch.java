import java.util.Scanner;

public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取主字串 haystack 和子字串 needle
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();

        // 計算子字串首次出現的索引
        int index = strStr(haystack, needle);

        // 輸出結果
        System.out.println(index);
    }

    public static int strStr(String haystack, String needle) {
        // 如果 needle 為空，返回 0
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // 如果 needle 長度大於 haystack，直接返回 -1
        if (m > n) {
            return -1;
        }

        // 暴力法逐起點比較
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i; // 找到子字串，返回起始索引
            }
        }

        return -1; // 未找到子字串
    }
}