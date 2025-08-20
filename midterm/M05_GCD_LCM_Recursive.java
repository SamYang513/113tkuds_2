import java.util.Scanner;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取輸入的兩個正整數
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        // 計算 GCD 與 LCM
        long gcd = gcd(a, b);
        long lcm = (a / gcd) * b; // 避免乘法溢位，先除後乘

        // 輸出結果
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);

        scanner.close();
    }

    // 使用遞迴的歐幾里得演算法計算 GCD
    private static long gcd(long x, long y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}