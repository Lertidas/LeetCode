import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem19 {
    // Using ListCode class as created for problem 2 in Problem2.java
    public String solve() {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        int n = 1;
        ListNode output = removeNthFromEnd(input, n);
        List<Integer> list = new ArrayList<>();
        while (output != null) {
            list.add(output.val);
            output = output.next;
        }
        return list.toString();
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int val = removeN(head, n);
        if (val == n) {
            head = head.next;
        }
        return head;
    }
    private int removeN(ListNode node, int n) {
        if (node.next != null) {
            int val = removeN(node.next, n);
            if (val == n) {
                node.next = node.next.next;
            }
            return val + 1;
        }
        else {
            return 1;
        }
    }
}
