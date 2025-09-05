import java.util.Scanner;

public class LC19_RemoveNth_Node_Clinic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n
        int n = scanner.nextInt();

        // 讀取鏈結串列的值
        ListNode dummy = new ListNode(0); // 建立虛擬頭節點
        ListNode current = dummy;
        for (int i = 0; i < n; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }

        // 讀取 k
        int k = scanner.nextInt();

        // 刪除倒數第 k 個節點
        ListNode newHead = removeNthFromEnd(dummy.next, k);

        // 輸出結果
        printList(newHead);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化雙指針
        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast 指針先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // fast 和 slow 同步移動，直到 fast 到達尾部
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 刪除倒數第 n 個節點
        slow.next = slow.next.next;

        // 返回新鏈結串列的頭節點
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