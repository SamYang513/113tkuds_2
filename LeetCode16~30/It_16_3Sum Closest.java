import java.util.Arrays;

public class It_16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 將陣列排序
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始化最接近的和

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // 如果當前和更接近目標，更新 closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 根據當前和與目標的比較，移動指標
                if (currentSum < target) {
                    left++; // 增加總和
                } else if (currentSum > target) {
                    right--; // 減少總和
                } else {
                    // 如果當前和等於目標，直接返回
                    return currentSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        It_16_3SumClosest solution = new It_16_3SumClosest();

        // 測試案例 1
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + solution.threeSumClosest(nums1, target1)); // 2

        // 測試案例 2
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + solution.threeSumClosest(nums2, target2)); // 0
    }
}