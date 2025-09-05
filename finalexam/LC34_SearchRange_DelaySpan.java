import java.util.Scanner;

public class LC34_SearchRange_DelaySpan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 target
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 讀取已排序的整數陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 查找目標值的首個與最後一個索引
        int[] range = searchRange(nums, target);

        // 輸出結果
        System.out.println(range[0] + " " + range[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findBound(nums, target, true);  // 找左邊界
        result[1] = findBound(nums, target, false); // 找右邊界
        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // 記錄當前索引
                if (isFirst) {
                    right = mid - 1; // 繼續向左搜尋
                } else {
                    left = mid + 1; // 繼續向右搜尋
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
}