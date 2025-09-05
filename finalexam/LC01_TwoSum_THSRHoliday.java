
import java.util.HashMap;
import java.util.Scanner;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 target
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        // 讀取座位數陣列
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.nextInt();
        }

        // 使用 HashMap 來記錄「需要的數」和「索引」
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍歷座位數陣列
        for (int i = 0; i < n; i++) {
            int current = seats[i];
            int complement = target - current;

            // 如果 map 中已經存在 complement，則找到解
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + " " + i);
                return;
            }

            // 否則，記錄當前數字和索引
            map.put(current, i);
        }

        // 如果遍歷結束仍未找到解，輸出 -1 -1
        System.out.println("-1 -1");
    }
}