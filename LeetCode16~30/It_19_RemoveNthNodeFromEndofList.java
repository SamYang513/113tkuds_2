class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 靜態方法：將字串轉換為鏈結串列
    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }

        String[] values = data.replaceAll("\\[|\\]", "").split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value.trim()));
            current = current.next;
        }

        return dummy.next;
    }

    // 輔助方法：將鏈結串列轉換為字串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        sb.append("[");
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class It_19_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        It_19_RemoveNthNodeFromEndofList solution = new It_19_RemoveNthNodeFromEndofList();

        // 測試案例 1
        String input1 = "[1,2,3,4,5]";
        int n1 = 2;
        ListNode head1 = ListNode.deserialize(input1);
        System.out.println("Input: " + head1 + ", n = " + n1);
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        System.out.println("Output: " + result1);

        // 測試案例 2
        String input2 = "[1]";
        int n2 = 1;
        ListNode head2 = ListNode.deserialize(input2);
        System.out.println("Input: " + head2 + ", n = " + n2);
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        System.out.println("Output: " + result2);
    }
}