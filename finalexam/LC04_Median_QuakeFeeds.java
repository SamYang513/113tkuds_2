import java.util.Scanner;

public class LC04_Median_QuakeFeeds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 讀取兩個已排序數列
        double[] nums1 = new double[n];
        double[] nums2 = new double[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextDouble();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = scanner.nextDouble();
        }

        // 計算中位數
        double median = findMedianSortedArrays(nums1, nums2);

        // 輸出結果，保留 1 位小數
        System.out.printf("%.1f\n", median);
    }

    public static double findMedianSortedArrays(double[] nums1, double[] nums2) {
        // 確保 nums1 是較短的數列
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;
        int totalLeft = (n + m + 1) / 2;

        int left = 0, right = n;

        while (left <= right) {
            int i = left + (right - left) / 2; // nums1 的切割點
            int j = totalLeft - i;            // nums2 的切割點

            double nums1LeftMax = (i == 0) ? Double.NEGATIVE_INFINITY : nums1[i - 1];
            double nums1RightMin = (i == n) ? Double.POSITIVE_INFINITY : nums1[i];
            double nums2LeftMax = (j == 0) ? Double.NEGATIVE_INFINITY : nums2[j - 1];
            double nums2RightMin = (j == m) ? Double.POSITIVE_INFINITY : nums2[j];

            // 檢查是否滿足條件
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 如果總長度是奇數，返回左半部分的最大值
                if ((n + m) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
                // 如果總長度是偶數，返回左右部分的平均值
                return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
            } else if (nums1LeftMax > nums2RightMin) {
                // 縮小 nums1 的右邊界
                right = i - 1;
            } else {
                // 增大 nums1 的左邊界
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}