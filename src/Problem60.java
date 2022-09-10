import java.util.ArrayList;
import java.util.List;

public class Problem60 {
    public String solve() {
        int n = 4;
        int k = 9;
        return getPermutation(n, k);
    }
    public String getPermutation(int n, int k) {
        // Setup strings
        List<String> values = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            values.add(String.valueOf(i));
        }
        int permutations;
        int index;
        k -= 1;
        // Get positions
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            permutations = getFactorial(i - 1);
            index = permutations != 0 ? k / permutations : 0;
            k = permutations != 0 ? k % permutations : 0;
            sb.append(values.get(index));
            values.remove(index);
        }
        return sb.toString();
    }
    private int getFactorial(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return n * getFactorial(n - 1);
        }
    }
}
