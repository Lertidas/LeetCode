import java.util.HashMap;

public class Problem20 {
    public String solve() {
        return Boolean.toString(isValid("]"));
    }
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        // Create hash map
        HashMap<Character, Character> convert = new HashMap<>();
        convert.put('[', ']');
        convert.put('(', ')');
        convert.put('{', '}');
        // Use a linked list to check for values
        char c = s.charAt(0);
        if (!convert.containsKey(c)) {
            return false;
        }
        ListNode node = new ListNode(convert.get(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (convert.containsKey(c)) {
                node = new ListNode(convert.get(c), node);
            }
            else if (node == null) {
                return false;
            }
            else if (c == node.val){
                node = node.next;
            }
            else {
                return false;
            }
        }
        return node == null;
    }
}
