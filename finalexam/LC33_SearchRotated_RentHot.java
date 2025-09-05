import java.util.Scanner;

public class LC33_SearchRotated_RentHot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 target
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 讀取旋轉後的升序陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 查找目標值的索引
        int index = search(nums, target);

        // 輸出結果
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 如果找到目標值，返回索引
            if (nums[mid] == target) {
                return mid;
            }

            // 判斷哪一半是有序的
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // 縮小到左半部分
                } else {
                    left = mid + 1; // 縮小到右半部分
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // 縮小到右半部分
                } else {
                    right = mid - 1; // 縮小到左半部分
                }
            }
        }

        // 如果未找到目標值，返回 -1
        return -1;
    }
}