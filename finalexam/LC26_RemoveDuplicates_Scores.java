import java.util.Scanner;

public class LC26_RemoveDuplicates_Scores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n
        int n = scanner.nextInt();

        // 讀取陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 移除重複項並獲取新長度
        int newLength = removeDuplicates(nums);

        // 輸出結果
        System.out.println(newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i]);
            if (i < newLength - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 使用雙指針法
        int write = 1; // 指向可寫位置
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write; // 返回新長度
    }
}