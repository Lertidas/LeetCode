import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public String solve() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3.val);
        while (l3.next != null) {
            l3 = l3.next;
            System.out.println(l3.val);
        }
        return "";
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        ListNode current = result;
        int remainder = value / 10;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            value = l1.val + l2.val + remainder;
            current.next = new ListNode(value % 10);
            remainder = value / 10;
            current = current.next;
        }
        // If l1 is not empty
        while (l1.next != null) {
            l1 = l1.next;
            value = l1.val + remainder;
            current.next = new ListNode(value % 10);
            remainder = value / 10;
            current = current.next;
        }
        // If l2 is not empty
        while (l2.next != null) {
            l2 = l2.next;
            value = l2.val + remainder;
            current.next = new ListNode(value % 10);
            remainder = value / 10;
            current = current.next;
        }
        if (remainder != 0) {
            current.next = new ListNode(remainder);
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
