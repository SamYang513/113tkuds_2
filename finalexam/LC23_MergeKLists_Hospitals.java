

import java.util.PriorityQueue;
import java.util.Scanner;

public class LC23_MergeKLists_Hospitals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 k
        int k = scanner.nextInt();
        ListNode[] lists = new ListNode[k];

        // 讀取 k 條鏈結串列
        for (int i = 0; i < k; i++) {
            lists[i] = readList(scanner);
        }

        // 合併 k 條鏈結串列
        ListNode mergedList = mergeKLists(lists);

        // 輸出結果
        printList(mergedList);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // 建立最小堆，根據節點值排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // 將每條鏈結串列的頭節點加入堆
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 從堆中取出最小節點，並將其後繼節點加入堆
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    // 輔助方法：讀取鏈結串列
    private static ListNode readList(Scanner scanner) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (true) {
            int val = scanner.nextInt();
            if (val == -1) {
                break;
            }
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // 輔助方法：列印鏈結串列
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // 定義鏈結串列的節點類
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}