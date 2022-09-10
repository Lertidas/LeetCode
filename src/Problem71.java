import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem71 {
    public String solve() {
        String path = "/a/./b/../../c/";
        return simplifyPath(path);
    }
    public String simplifyPath(String path) {
        // Setup values to start
        HashSet<String> invalid = new HashSet<>();
        String[] vals = path.split("/");
        invalid.add("");
        invalid.add(".");
        invalid.add("..");

        // Linked list
        LinkedList<String> values = new LinkedList<>();
        for (String s : vals) {
            if (s.equals("..")) {
                if (values.size() > 0) {
                    values.removeLast();
                }
            }
            else if (!invalid.contains(s)) {
                values.addLast(s);
            }
        }

        // Create String result
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i != values.size() - 1) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
