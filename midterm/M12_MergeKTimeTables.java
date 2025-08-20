import java.util.*;

public class M12_MergeKTimeTables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 K 條列表
        int K = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> timeTables = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int len = Integer.parseInt(scanner.nextLine()); // 讀取當前列表長度
            List<Integer> times = new ArrayList<>();
            String[] timeStrings = scanner.nextLine().split(" ");
            for (String time : timeStrings) {
                times.add(Integer.parseInt(time));
            }
            timeTables.add(times);
        }

        // 合併時刻表
        List<Integer> mergedList = mergeKTimeTables(timeTables);

        // 輸出結果
        for (int time : mergedList) {
            System.out.print(time + " ");
        }

        scanner.close();
    }

    // 合併 K 條已排序的時刻表
    private static List<Integer> mergeKTimeTables(List<List<Integer>> timeTables) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.time));

        // 初始化 Min-Heap，將每條列表的第一個元素加入
        for (int i = 0; i < timeTables.size(); i++) {
            if (!timeTables.get(i).isEmpty()) {
                minHeap.offer(new Element(timeTables.get(i).get(0), i, 0));
            }
        }

        // 合併過程
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.time);

            // 將同來源列表的下一個元素加入 Min-Heap
            int nextIndex = current.index + 1;
            if (nextIndex < timeTables.get(current.listIndex).size()) {
                minHeap.offer(new Element(timeTables.get(current.listIndex).get(nextIndex), current.listIndex, nextIndex));
            }
        }

        return result;
    }

    // 定義 Min-Heap 中的元素類別
    static class Element {
        int time;       // 時刻
        int listIndex;  // 來源列表的索引
        int index;      // 該列表中的元素索引

        Element(int time, int listIndex, int index) {
            this.time = time;
            this.listIndex = listIndex;
            this.index = index;
        }
    }
}