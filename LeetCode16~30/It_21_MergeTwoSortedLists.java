public class It_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 如果其中一個鏈結串列還有剩餘節點，直接接到結果鏈結串列後面
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        It_21_MergeTwoSortedLists solution = new It_21_MergeTwoSortedLists();

        // 測試案例 1
        ListNode list1 = ListNode.deserialize("[1,2,4]");
        ListNode list2 = ListNode.deserialize("[1,3,4]");
        System.out.println("Input: list1 = " + list1 + ", list2 = " + list2);
        ListNode result1 = solution.mergeTwoLists(list1, list2);
        System.out.println("Output: " + result1);

        // 測試案例 2
        ListNode list3 = ListNode.deserialize("[]");
        ListNode list4 = ListNode.deserialize("[]");
        System.out.println("Input: list1 = " + list3 + ", list2 = " + list4);
        ListNode result2 = solution.mergeTwoLists(list3, list4);
        System.out.println("Output: " + result2);

        // 測試案例 3
        ListNode list5 = ListNode.deserialize("[]");
        ListNode list6 = ListNode.deserialize("[0]");
        System.out.println("Input: list1 = " + list5 + ", list2 = " + list6);
        ListNode result3 = solution.mergeTwoLists(list5, list6);
        System.out.println("Output: " + result3);
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