

import java.util.Scanner;

public class LC24_SwapPairs_Shifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取鏈結串列
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (scanner.hasNextInt()) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        // 交換相鄰節點
        ListNode swappedList = swapPairs(dummy.next);

        // 輸出結果
        printList(swappedList);
    }

    public static ListNode swapPairs(ListNode head) {
        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 遍歷鏈結串列，交換相鄰節點
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // 交換節點
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 移動 prev 到下一對節點之前
            prev = first;
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