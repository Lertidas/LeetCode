import java.util.*;

public class Problem56Revised {
    public String solve() {
        int[][] intervals = new int[3][];
        intervals[0] = new int[]{1, 4};
        intervals[1] = new int[]{0, 2};
        intervals[2] = new int[]{3, 5};

        return Arrays.deepToString(merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        // Sort
        List<int[]> lst = Arrays.asList(intervals);
        lst.sort(new IntervalCompare());
        // Merge
        List<int[]> result = new ArrayList<>();
        int start = lst.get(0)[0];
        int end = lst.get(0)[1];
        for (int i = 1; i < lst.size(); i++) {
            // Check to merge
            if (lst.get(i)[0] <= end) {
                lst.get(i)[0] = start;
                if (lst.get(i)[1] < end) {
                    lst.get(i)[1] = end;
                }
            }
            // Else prev to list
            else {
                result.add(lst.get(i - 1));
            }
            start = lst.get(i)[0];
            end = lst.get(i)[1];
        }
        result.add(lst.get(lst.size() - 1));
        // Convert to array
        int[][] arrayResult = new int[result.size()][];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }
    private static class IntervalCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0]) {
                return -1;
            }
            else if (o1[0] == o2[0]) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
