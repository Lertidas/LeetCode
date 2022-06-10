import java.util.ArrayList;
import java.util.List;

public class Problem24 {
    public String solve() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // Result
        ListNode output = swapPairs(head);
        // Print out values
        List<Integer> list = new ArrayList<>();
        while (output != null) {
            list.add(output.val);
            output = output.next;
        }
        return list.toString();
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        else {
            ListNode newHead = swapPairs(head.next.next);
            ListNode l1 = head.next;
            head.next = newHead;
            l1.next = head;
            return l1;
        }
    }
}
