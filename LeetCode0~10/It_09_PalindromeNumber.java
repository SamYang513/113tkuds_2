public class It_09_PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 負數或最後一位是 0（但數字不是 0）都不是回文數
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        // 反轉整數的一半
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // 如果 x 等於 reversed 或 x 等於 reversed 去掉最後一位，則是回文數
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        It_09_PalindromeNumber solution = new It_09_PalindromeNumber();

        // 測試案例 1
        int x1 = 121;
        System.out.println("Input: " + x1);
        System.out.println("Output: " + solution.isPalindrome(x1)); // true

        // 測試案例 2
        int x2 = -121;
        System.out.println("Input: " + x2);
        System.out.println("Output: " + solution.isPalindrome(x2)); // false

        // 測試案例 3
        int x3 = 10;
        System.out.println("Input: " + x3);
        System.out.println("Output: " + solution.isPalindrome(x3)); // false

        // 測試案例 4
        int x4 = 0;
        System.out.println("Input: " + x4);
        System.out.println("Output: " + solution.isPalindrome(x4)); // true
    }
}