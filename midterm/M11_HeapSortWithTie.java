import java.util.*;

public class M11_HeapSortWithTie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取學生數量
        int n = Integer.parseInt(scanner.nextLine());
        int[] scores = Arrays.stream(scanner.nextLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();

        // 將分數與索引封裝為對象
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            students.add(new Student(scores[i], i));
        }

        // 使用 PriorityQueue 作為 Max-Heap
        PriorityQueue<Student> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.score != a.score) {
                return b.score - a.score; // 分數高者優先
            }
            return a.index - b.index; // 分數相同時，索引小者優先
        });

        // 將所有學生加入 Max-Heap
        maxHeap.addAll(students);

        // 從 Max-Heap 中取出元素，按遞增順序存入結果
        int[] sortedScores = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedScores[i] = maxHeap.poll().score;
        }

        // 輸出結果
        for (int score : sortedScores) {
            System.out.print(score + " ");
        }

        scanner.close();
    }

    // 定義學生類別
    static class Student {
        int score;
        int index;

        Student(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }
}