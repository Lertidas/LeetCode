public class Problem83 implements Problem{
    @Override
    public String solve() {
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(1)));
        return deleteDuplicates(head).toString();
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            // If dupe
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
