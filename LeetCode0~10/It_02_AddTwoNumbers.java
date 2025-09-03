public class It_02_AddTwoNumbers {
    // 定義鏈結串列的節點類別
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 虛擬頭節點
        ListNode p = l1, q = l2, current = dummyHead;
        int carry = 0; // 進位

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;

            carry = sum / 10; // 計算進位
            current.next = new ListNode(sum % 10); // 新節點存儲當前位數
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // 如果還有進位，新增一個節點
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next; // 返回結果鏈結串列的頭節點
    }

    public static void main(String[] args) {
        It_02_AddTwoNumbers solution = new It_02_AddTwoNumbers();

        // 測試案例 1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(result); // [7, 0, 8]

        // 測試案例 2
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);

        result = solution.addTwoNumbers(l3, l4);
        System.out.print("Output: ");
        printList(result); // [0]

        // 測試案例 3
        ListNode l5 = new ListNode(9);
        l5.next = new ListNode(9);
        l5.next.next = new ListNode(9);
        l5.next.next.next = new ListNode(9);
        l5.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next = new ListNode(9);
        l5.next.next.next.next.next.next = new ListNode(9);

        ListNode l6 = new ListNode(9);
        l6.next = new ListNode(9);
        l6.next.next = new ListNode(9);
        l6.next.next.next = new ListNode(9);

        result = solution.addTwoNumbers(l5, l6);
        System.out.print("Output: ");
        printList(result); // [8, 9, 9, 9, 0, 0, 0, 1]
    }

    // 輔助方法：列印鏈結串列
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}