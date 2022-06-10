import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public String solve() {
        return generateParenthesis(1).toString();
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        getParenthesis(result, n, "", 0, 0);
        return result;
    }
    private void getParenthesis(List<String> list, int limit, String s, int m, int n) {
        if (limit == n) {
            list.add(s);
        }
        else if (limit == m) {
            getParenthesis(list, limit, s + ')', m, n + 1);
        }
        else if (m == n) {
            getParenthesis(list, limit, s + '(', m + 1, n);
        }
        else {
            getParenthesis(list, limit, s + '(', m + 1, n);
            getParenthesis(list, limit, s + ')', m, n + 1);
        }
    }
}
