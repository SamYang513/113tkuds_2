import java.util.Scanner;

public class LC27_RemoveElement_Recycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 val
        int n = scanner.nextInt();
        int val = scanner.nextInt();

        // 讀取陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 移除指定元素並獲取新長度
        int newLength = removeElement(nums, val);

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

    public static int removeElement(int[] nums, int val) {
        int write = 0; // 指向下一個可寫入的位置

        // 遍歷陣列
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                nums[write] = nums[read];
                write++;
            }
        }

        return write; // 返回新長度
    }
}