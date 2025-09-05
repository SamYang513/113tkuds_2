

import java.util.Scanner;

public class LC25_ReverseKGroup_Shifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 k
        int k = scanner.nextInt();

        // 讀取鏈結串列
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (scanner.hasNextInt()) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        // 分組反轉鏈結串列
        ListNode reversedList = reverseKGroup(dummy.next, k);

        // 輸出結果
        printList(reversedList);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 檢查是否有足夠的節點進行反轉
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) {
                    return dummy.next; // 不足 k 節點，直接返回
                }
            }

            // 保存下一組的起點
            ListNode nextGroupStart = groupEnd.next;

            // 反轉當前組
            reverse(groupStart, groupEnd);

            // 更新指標
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;
            prevGroupEnd = groupStart;
        }
    }

    // 輔助方法：反轉鏈結串列的一段
    private static void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;
        ListNode stop = end.next;

        while (current != stop) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
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