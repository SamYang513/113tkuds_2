

import java.util.Scanner;

public class LC21_MergeTwoLists_Clinics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 讀取第一條鏈結串列
        ListNode l1 = readList(scanner, n);

        // 讀取第二條鏈結串列
        ListNode l2 = readList(scanner, m);

        // 合併兩條鏈結串列
        ListNode mergedList = mergeTwoLists(l1, l2);

        // 輸出結果
        printList(mergedList);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 合併兩條鏈結串列
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 接上剩餘的節點
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    // 輔助方法：讀取鏈結串列
    private static ListNode readList(Scanner scanner, int size) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < size; i++) {
            current.next = new ListNode(scanner.nextInt());
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