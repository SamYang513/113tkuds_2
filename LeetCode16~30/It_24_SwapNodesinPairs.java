public class It_24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        // 如果鏈結串列為空或只有一個節點，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 交換第一對節點
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // 遞迴處理剩餘的節點
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // 返回新的頭節點
        return secondNode;
    }

    public static void main(String[] args) {
        It_24_SwapNodesinPairs solution = new It_24_SwapNodesinPairs();

        // 測試案例 1
        ListNode head1 = ListNode.deserialize("[1,2,3,4]");
        System.out.println("Input: " + head1);
        System.out.println("Output: " + solution.swapPairs(head1));

        // 測試案例 2
        ListNode head2 = ListNode.deserialize("[]");
        System.out.println("Input: " + head2);
        System.out.println("Output: " + solution.swapPairs(head2));

        // 測試案例 3
        ListNode head3 = ListNode.deserialize("[1]");
        System.out.println("Input: " + head3);
        System.out.println("Output: " + solution.swapPairs(head3));

        // 測試案例 4
        ListNode head4 = ListNode.deserialize("[1,2,3]");
        System.out.println("Input: " + head4);
        System.out.println("Output: " + solution.swapPairs(head4));
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