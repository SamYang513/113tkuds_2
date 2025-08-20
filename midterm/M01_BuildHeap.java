import java.util.*;

public class M01_BuildHeap {
    private int[] heap;
    private int size;
    private boolean isMaxHeap;

    // 建構子，初始化堆積
    public M01_BuildHeap(int[] arr, String type) {
        this.size = arr.length;
        this.heap = Arrays.copyOf(arr, size);
        this.isMaxHeap = type.equalsIgnoreCase("max");
        buildHeap();
    }

    // 建構堆積（自底向上）
    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // 堆積化（調整節點位置）
    private void heapify(int i) {
        int extreme = i; // 最大值或最小值的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 比較左子節點
        if (left < size && compare(heap[left], heap[extreme])) {
            extreme = left;
        }

        // 比較右子節點
        if (right < size && compare(heap[right], heap[extreme])) {
            extreme = right;
        }

        // 如果極值發生變化，交換並遞迴調整
        if (extreme != i) {
            swap(i, extreme);
            heapify(extreme);
        }
    }

    // 比較方法，根據堆積類型決定比較邏輯
    private boolean compare(int child, int parent) {
        return isMaxHeap ? child > parent : child < parent;
    }

    // 交換陣列中的兩個元素
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 出堆操作（取出堆頂元素）
    public int extractTop() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int top = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return top;
    }

    // 輸出堆積內容
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        // 測試資料
        int[] arr = {4, 10, 3, 5, 1, 15, 20 ,17};
        String type = "max"; // 可選 "max" 或 "min"

        M01_BuildHeap heap = new M01_BuildHeap(arr, type);
        System.out.println("建構完成的堆積：");
        heap.printHeap();

        System.out.println("依序出堆：");
        while (heap.size > 0) {
            System.out.print(heap.extractTop() + " ");
        }
    }
}