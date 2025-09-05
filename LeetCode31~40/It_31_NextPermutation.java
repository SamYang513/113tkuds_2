import java.util.Arrays;

public class It_31_NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 示例輸入
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // 輸出結果
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. 從後往前找到第一個升序對 (i, i+1)，即 nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. 如果找到了升序對，從後往前找到第一個比 nums[i] 大的數字，並交換
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 反轉 i+1 到末尾的數字，使其變為最小排列
        reverse(nums, i + 1, n - 1);
    }

    // 輔助方法：交換陣列中的兩個元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 輔助方法：反轉陣列的一部分
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}