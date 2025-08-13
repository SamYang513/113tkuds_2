import java.util.*;

public class ValidMaxHeapChecker {
    private List<Integer> heap;

    // 建構子，將陣列轉換為 List
    public ValidMaxHeapChecker(int[] arr) {
        heap = new ArrayList<>();
        for (int num : arr) {
            heap.add(num);
        }
    }

    // 計算左子節點的索引
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 計算右子節點的索引
    private static int rightChild(int i) {
        return 2 * i + 2;
    }

    // 檢查是否符合 Max Heap 性質，並回傳第一個違反規則的節點索引
    public static int findFirstViolation(ValidMaxHeapChecker heapChecker) {
        List<Integer> heap = heapChecker.heap;
        for (int i = 0; i < heap.size(); i++) {
            int left = leftChild(i);
            int right = rightChild(i);

            // 檢查左子節點是否違反 Max Heap 性質
            if (left < heap.size() && heap.get(i) < heap.get(left)) {
                return i; // 回傳第一個違反規則的父節點索引
            }

            // 檢查右子節點是否違反 Max Heap 性質
            if (right < heap.size() && heap.get(i) < heap.get(right)) {
                return i; // 回傳第一個違反規則的父節點索引
            }
        }
        return -1; // 如果符合 Max Heap 性質，回傳 -1
    }

    public static void main(String[] args) {
        int[] arr = {100, 90, 80, 95, 60, 75, 65}; // 測試用陣列
        ValidMaxHeapChecker heapChecker = new ValidMaxHeapChecker(arr);
        int violationIndex = findFirstViolation(heapChecker);

        if (violationIndex == -1) {
            System.out.println("該陣列符合 Max Heap 性質。");
        } else {
            System.out.println("該陣列不符合 Max Heap 性質，第一個違反規則的節點索引為: " + violationIndex);
        }
    }
}