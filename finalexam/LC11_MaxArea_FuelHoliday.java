import java.util.Scanner;

public class LC11_MaxArea_FuelHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n
        int n = scanner.nextInt();

        // 讀取高度陣列
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        // 計算最大面積
        int maxArea = maxArea(heights);

        // 輸出結果
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int left = 0; // 左指針
        int right = height.length - 1; // 右指針
        int maxArea = 0;

        while (left < right) {
            // 計算當前面積
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            // 移動較短邊
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}