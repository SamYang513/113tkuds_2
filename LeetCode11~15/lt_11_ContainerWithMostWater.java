public class lt_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0; // 左指標
        int right = height.length - 1; // 右指標
        int maxArea = 0;

        // 雙指標方法
        while (left < right) {
            // 計算兩指標之間形成的容器面積
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            // 更新最大面積
            maxArea = Math.max(maxArea, area);

            // 移動指向較短線段的指標
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        lt_11_ContainerWithMostWater solution = new lt_11_ContainerWithMostWater();

        // 測試案例 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("最大面積: " + solution.maxArea(height1)); // 輸出: 49

        // 測試案例 2
        int[] height2 = {1, 1};
        System.out.println("最大面積: " + solution.maxArea(height2)); // 輸出: 1
    }
}