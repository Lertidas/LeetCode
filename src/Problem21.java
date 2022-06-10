import java.util.ArrayList;
import java.util.List;

public class Problem21 {
    public String solve() {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode(0);
        // Print out values
        List<Integer> list = new ArrayList<>();
        ListNode output = mergeTwoLists(null, l2);
        while (output != null) {
            list.add(output.val);
            output = output.next;
        }
        return list.toString();
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
