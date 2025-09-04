public class It_25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 檢查鏈結串列是否有足夠的節點進行反轉
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // 如果節點數量不足 k，直接返回頭節點
        if (count < k) {
            return head;
        }

        // 反轉前 k 個節點
        ListNode prev = null;
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // 遞迴處理剩餘的節點
        head.next = reverseKGroup(current, k);

        // 返回新的頭節點
        return prev;
    }

    public static void main(String[] args) {
        It_25ReverseNodesInKGroup solution = new It_25ReverseNodesInKGroup();

        // 測試案例 1
        ListNode head1 = ListNode.deserialize("[1,2,3,4,5]");
        int k1 = 2;
        System.out.println("Input: head = " + head1 + ", k = " + k1);
        System.out.println("Output: " + solution.reverseKGroup(head1, k1));

        // 測試案例 2
        ListNode head2 = ListNode.deserialize("[1,2,3,4,5]");
        int k2 = 3;
        System.out.println("Input: head = " + head2 + ", k = " + k2);
        System.out.println("Output: " + solution.reverseKGroup(head2, k2));
    }
}

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