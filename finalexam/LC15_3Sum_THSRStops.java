import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC15_3Sum_THSRStops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n
        int n = scanner.nextInt();

        // 讀取整數陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 計算三元組
        List<List<Integer>> result = threeSum(nums);

        // 輸出結果
        for (List<Integer> triplet : result) {
            System.out.println(triplet.get(0) + " " + triplet.get(1) + " " + triplet.get(2));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 排序陣列
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 如果當前數字大於 0，則無需繼續，因為後面的數字也大於 0
            if (nums[i] > 0) {
                break;
            }

            // 跳過重複的數字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用雙指針法
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一組三元組
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳過重複的數字
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移動指針
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 如果總和小於 0，移動左指針
                    left++;
                } else {
                    // 如果總和大於 0，移動右指針
                    right--;
                }
            }
        }

        return result;
    }
}