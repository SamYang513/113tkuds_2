public class It_27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 使用雙指標法
        int index = 0; // 指向下一個應該放置非 val 元素的位置

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        // 返回非 val 元素的數量
        return index;
    }

    public static void main(String[] args) {
        It_27_RemoveElement solution = new It_27_RemoveElement();

        // 測試案例 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("Input: nums = [3,2,2,3], val = 3");
        System.out.println("Output: k = " + k1 + ", nums = " + arrayToString(nums1, k1));

        // 測試案例 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("Input: nums = [0,1,2,2,3,0,4,2], val = 2");
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