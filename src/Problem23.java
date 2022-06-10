import java.util.ArrayList;
import java.util.List;

public class Problem23 {
    public String solve() {
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(11);
        ListNode l3 = new ListNode(6);
        l3.next = new ListNode(10);
        ListNode[] nodes = new ListNode[]{null, l1, null, l3};

        // Result
        ListNode output = mergeKLists(nodes);
        // Print out values
        List<Integer> list = new ArrayList<>();
        while (output != null) {
            list.add(output.val);
            output = output.next;
        }
        return list.toString();
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode[] temp;
        while (lists.length > 1) {
            temp = new ListNode[(lists.length + 1) / 2];
            for (int i = 1; i < lists.length; i+=2) {
                temp[i / 2] = mergeTwoLists(lists[i - 1], lists[i]);
            }
            if (lists.length % 2 != 0) {
                temp[0] = mergeTwoLists(temp[0], lists[lists.length - 1]);
            }
            lists = temp;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode headPointer = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.val = list1.val;
                head.next = new ListNode();
                head = head.next;
                list1 = list1.next;
            }
            else {
                head.val = list2.val;
                head.next = new ListNode();
                head = head.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            head.val = list1.val;
            head.next = list1.next;
        }
        else {
            head.val = list2.val;
            head.next = list2.next;
        }
        return headPointer;
    }
}
