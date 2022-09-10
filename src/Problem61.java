public class Problem61 {
    public String solve() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        int k = 2;
        return rotateRight(head, k).toString();
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n = getLength(head);
        if (n == 0) {
            return null;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        int index = n - k;
        if (index == 0) {
            return head;
        }
        else {
            int count = 0;
            ListNode newHead;
            ListNode prevNode = head;
            ListNode current = head;
            while (count < index) {
                if (count == index - 1) {
                    prevNode = current;
                }
                current = current.next;
                count += 1;
            }
            newHead = current;
            while (current.next != null) {
                current = current.next;
            }
            current.next = head;
            prevNode.next = null;
            return newHead;
        }
    }
    private int getLength(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
