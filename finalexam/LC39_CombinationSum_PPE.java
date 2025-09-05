import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC39_CombinationSum_PPE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 target
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 讀取物資價格清單
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }

        // 計算所有可行的組合
        List<List<Integer>> combinations = combinationSum(candidates, target);

        // 輸出結果
        for (List<Integer> combination : combinations) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 排序以便於剪枝
        Arrays.sort(candidates);

        // 回溯法計算組合
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        // 如果剩餘值為 0，將當前組合加入結果
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // 遍歷候選數字
        for (int i = start; i < candidates.length; i++) {
            // 如果當前數字大於剩餘值，直接剪枝
            if (candidates[i] > target) {
                break;
            }

            // 選擇當前數字
            combination.add(candidates[i]);

            // 繼續遞迴，下一層仍從當前數字開始（允許重複使用）
            backtrack(candidates, target - candidates[i], i, combination, result);

            // 回溯，移除最後一個數字
            combination.remove(combination.size() - 1);
        }
    }
}