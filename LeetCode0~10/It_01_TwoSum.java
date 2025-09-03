import java.util.*;

public class It_01_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 使用哈希表來儲存數字和它們的索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍歷陣列
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 計算目標值與當前數字的差值

            // 如果哈希表中存在差值，則返回結果
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            // 將當前數字和索引加入哈希表
            map.put(nums[i], i);
        }

        // 根據題目保證有解，不會執行到這裡
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        It_01_TwoSum solution = new It_01_TwoSum();

        // 測試案例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums1, target1))); // [0, 1]

        // 測試案例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums2, target2))); // [1, 2]

        // 測試案例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(nums3, target3))); // [0, 1]
    }
}