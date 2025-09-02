import java.util.*;

public class It_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 將陣列排序

        for (int i = 0; i < nums.length - 2; i++) {
            // 避免重複的三元組
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳過重複的元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // 增加總和
                } else {
                    right--; // 減少總和
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        It_15_3Sum solution = new It_15_3Sum();

        // 測試案例 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.threeSum(nums1));

        // 測試案例 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.threeSum(nums2));

        // 測試案例 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.threeSum(nums3));
    }
}