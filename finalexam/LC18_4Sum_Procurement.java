import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC18_4Sum_Procurement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 target
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 讀取整數陣列
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 計算四元組
        List<List<Integer>> result = fourSum(nums, target);

        // 輸出結果
        for (List<Integer> quad : result) {
            System.out.println(quad.get(0) + " " + quad.get(1) + " " + quad.get(2) + " " + quad.get(3));
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 排序陣列
        Arrays.sort(nums);

        int n = nums.length;

        // 固定第一個數字 i
        for (int i = 0; i < n - 3; i++) {
            // 跳過重複的數字
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 固定第二個數字 j
            for (int j = i + 1; j < n - 2; j++) {
                // 跳過重複的數字
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 使用雙指針法
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // 找到一組四元組
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

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
                    } else if (sum < target) {
                        // 如果總和小於 target，移動左指針
                        left++;
                    } else {
                        // 如果總和大於 target，移動右指針
                        right--;
                    }
                }
            }
        }

        return result;
    }
}