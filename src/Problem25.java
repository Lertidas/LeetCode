import java.util.ArrayList;
import java.util.List;

public class Problem25 {
    public String solve() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int k = 4;
        // Result
        ListNode output = reverseKGroup(head, k);
        // Print out values
        List<Integer> list = new ArrayList<>();
        while (output != null) {
            list.add(output.val);
            output = output.next;
        }
        return list.toString();
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode[] nodes = new ListNode[k];
        ListNode originalHead = head;
        // Handle case where there are less than k nodes left
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return originalHead;
            }
            nodes[i] = head;
            head = head.next;
        }
        ListNode headToReturn = null;
        // Handle case where there are at least k nodes left
        for (int i = 0; i < k / 2; i++) {
            // Set new head - Handle case at i == 0
            if (i == 0) {
                ListNode newHead = reverseKGroup(head, k);
                nodes[k - 1].next = nodes[k - 2];
                nodes[0].next = newHead;
                headToReturn = nodes[k - 1];
            }
            // Swap values
            else {
                nodes[k - 1 - i].next = nodes[k - 2 - i];
                nodes[i].next = nodes[i - 1];
            }
            if (i == (k / 2) - 1 && k % 2 != 0) {
                nodes[k / 2].next = nodes[(k / 2) - 1];
                nodes[(k / 2) + 1].next = nodes[k / 2];
            }
        }
        return headToReturn;
    }
}
