import java.util.PriorityQueue;

public class It_23_MergekSortedLists {
    // 定義 ListNode 類
    public static class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        // 使用優先佇列（最小堆）來排序節點
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 將每個鏈結串列的頭節點加入優先佇列
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // 建立虛擬頭節點
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 從優先佇列中取出最小值，並將下一個節點加入佇列
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        It_23_MergekSortedLists solution = new It_23_MergekSortedLists();

        // 測試案例 1
        ListNode[] lists1 = {
            ListNode.deserialize("[1,4,5]"),
            ListNode.deserialize("[1,3,4]"),
            ListNode.deserialize("[2,6]")
        };
        System.out.println("Input: lists = [[1,4,5],[1,3,4],[2,6]]");
        System.out.println("Output: " + solution.mergeKLists(lists1));

        // 測試案例 2
        ListNode[] lists2 = {};
        System.out.println("Input: lists = []");
        System.out.println("Output: " + solution.mergeKLists(lists2));

        // 測試案例 3
        ListNode[] lists3 = {ListNode.deserialize("[]")};
        System.out.println("Input: lists = [[]]");
        System.out.println("Output: " + solution.mergeKLists(lists3));
    }
}