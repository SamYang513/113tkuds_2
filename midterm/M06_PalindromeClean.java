import java.util.Scanner;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入字串
        String s = scanner.nextLine();

        // 判斷是否為回文並輸出結果
        if (isPalindrome(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }

    // 判斷字串是否為回文的方法
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // 忽略非英文字母
            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }

            // 比較兩端字母（忽略大小寫）
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}