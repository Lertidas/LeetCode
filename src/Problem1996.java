import java.util.Arrays;
import java.util.Comparator;

public class Problem1996 implements Problem {
    @Override
    public String solve() {
        int[][] properties = new int[4][];
        properties[0] = new int[]{1, 1};
        properties[1] = new int[]{2, 1};
        properties[2] = new int[]{2, 2};
        properties[3] = new int[]{1, 2};
        return String.valueOf(numberOfWeakCharacters(properties));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        int prevMax = 0;
        int currentMax = properties[properties.length - 1][1];
        boolean same;
        for (int i = properties.length - 2; i >= 0; i--) {
            if (properties[i][0] == properties[i + 1][0]) {
                same = true;
            }
            else {
                same = false;
                if (currentMax > prevMax) {
                    prevMax = currentMax;
                }
            }
            if (same) {
                if (properties[i][1] < prevMax) {
                    count++;
                }
                if (properties[i][1] > currentMax) {
                    currentMax = properties[i][1];
                }
            }
            else {
                if (properties[i][1] < currentMax) {
                    count++;
                }
                else if (properties[i][1] > currentMax) {
                    currentMax = properties[i][1];
                }
            }
        }
        return count;
    }
}
