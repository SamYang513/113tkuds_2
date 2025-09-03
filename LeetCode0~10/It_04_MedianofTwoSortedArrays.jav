public class It_04_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 確保 nums1 是較短的陣列
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0, right = m;

        while (left <= right) {
            int i = left + (right - left) / 2; // nums1 的分割點
            int j = totalLeft - i; // nums2 的分割點

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 找到正確的分割點
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if (nums1LeftMax > nums2RightMin) {
                right = i - 1; // 縮小 nums1 的分割範圍
            } else {
                left = i + 1; // 增大 nums1 的分割範圍
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        It_04_MedianofTwoSortedArrays solution = new It_04_MedianofTwoSortedArrays();

        // 測試案例 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Input: nums1 = [1, 3], nums2 = [2]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums1, nums2)); // 2.0

        // 測試案例 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Input: nums1 = [1, 2], nums2 = [3, 4]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums3, nums4)); // 2.5
    }
}