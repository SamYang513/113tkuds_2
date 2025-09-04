public class It_26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 使用雙指標法
        int uniqueIndex = 0; // 指向最後一個唯一元素的位置

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++; // 移動 uniqueIndex
                nums[uniqueIndex] = nums[i]; // 將當前元素放到 uniqueIndex 的下一個位置
            }
        }

        // 返回唯一元素的數量
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        It_26_RemoveDuplicatesfromSortedArray solution = new It_26_RemoveDuplicatesfromSortedArray();

        // 測試案例 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Input: [1,1,2]");
        System.out.println("Output: k = " + k1 + ", nums = " + arrayToString(nums1, k1));

        // 測試案例 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Input: [0,0,1,1,1,2,2,3,3,4]");
        System.out.println("Output: k = " + k2 + ", nums = " + arrayToString(nums2, k2));
    }

    // 輔助方法：將陣列轉換為字串，僅顯示前 k 個元素
    private static String arrayToString(int[] nums, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < k; i++) {
            sb.append(nums[i]);
            if (i < k - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
