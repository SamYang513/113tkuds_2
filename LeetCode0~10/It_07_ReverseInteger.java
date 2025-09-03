
public class It_07_ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10; // 提取最後一位數字
            x /= 10; // 移除最後一位數字

            // 檢查是否會溢出
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // 正溢出
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // 負溢出
            }

            // 將數字加入反轉結果
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        It_07_ReverseInteger solution = new It_07_ReverseInteger();

        // 測試案例 1
        int x1 = 123;
        System.out.println("Input: " + x1);
        System.out.println("Output: " + solution.reverse(x1)); // 321

        // 測試案例 2
        int x2 = -123;
        System.out.println("Input: " + x2);
        System.out.println("Output: " + solution.reverse(x2)); // -321

        // 測試案例 3
        int x3 = 120;
        System.out.println("Input: " + x3);
        System.out.println("Output: " + solution.reverse(x3)); // 21

        // 測試案例 4
        int x4 = 0;
        System.out.println("Input: " + x4);
        System.out.println("Output: " + solution.reverse(x4)); // 0

        // 測試案例 5 (溢出情況)
        int x5 = 1534236469;
        System.out.println("Input: " + x5);
        System.out.println("Output: " + solution.reverse(x5)); // 0
    }
}