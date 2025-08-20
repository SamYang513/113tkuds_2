import java.util.Scanner;

public class M02_YouBikeNextArrival {
    // 將時間轉換為自 00:00 起的分鐘數
    private static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // 找到第一個大於查詢時間的位置
    public static String findNextArrival(String[] supplyTimes, String queryTime) {
        int queryMinutes = timeToMinutes(queryTime);
        int left = 0, right = supplyTimes.length - 1;
        String result = "No bike";

        // 使用二分搜尋法
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midMinutes = timeToMinutes(supplyTimes[mid]);

            if (midMinutes > queryMinutes) {
                result = supplyTimes[mid]; // 更新結果為目前找到的時間
                right = mid - 1; // 繼續搜尋左半部
            } else {
                left = mid + 1; // 繼續搜尋右半部
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取補給時間數量
        int n = Integer.parseInt(scanner.nextLine());
        String[] supplyTimes = new String[n];

        // 讀取補給時間
        for (int i = 0; i < n; i++) {
            supplyTimes[i] = scanner.nextLine();
        }

        // 讀取查詢時間
        String queryTime = scanner.nextLine();

        // 呼叫方法並輸出結果
        String nextArrival = findNextArrival(supplyTimes, queryTime);
        System.out.println(nextArrival);

        scanner.close();
    }
}