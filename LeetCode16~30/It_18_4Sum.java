import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class It_18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums); // 將陣列排序

        for (int i = 0; i < nums.length - 3; i++) {
            // 避免重複的四元組
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // 避免重複的四元組
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳過重複的數字
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
        }

        return result;
    }

    public static void main(String[] args) {
        It_18_4Sum solution = new It_18_4Sum();

        // 測試案例 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + solution.fourSum(nums1, target1)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        // 測試案例 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + solution.fourSum(nums2, target2)); // [[2, 2, 2, 2]]
    }
}