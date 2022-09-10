import java.util.*;

public class Problem57 {
    public String solve() {
        int[][] intervals = new int[1][];
        intervals[0] = new int[]{1, 5};

        int[] newInterval = new int[]{2, 7};
        return Arrays.deepToString(insert(intervals, newInterval));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Check for null case
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // Sort
        List<int[]> lst = Arrays.asList(intervals);
        LinkedList<int[]> linkedList = new LinkedList<>(lst);
        // Insert value
        boolean added = false;
        for (int i = 0; i < linkedList.size(); i++) {
            if (newInterval[0] <= linkedList.get(i)[0]) {
                linkedList.add(i, newInterval);
                added = true;
                break;
            }
        }
        if (!added) {
            linkedList.addLast(newInterval);
        }
        // Then merge rest
        List<int[]> result = new ArrayList<>();
        int start = linkedList.get(0)[0];
        int end = linkedList.get(0)[1];
        for (int i = 0; i < linkedList.size(); i++) {
            // Check to merge
            if (linkedList.get(i)[0] <= end) {
                linkedList.get(i)[0] = start;
                if (linkedList.get(i)[1] < end) {
                    linkedList.get(i)[1] = end;
                }
            }
            // Else prev to list
            else {
                result.add(linkedList.get(i - 1));
            }
            start = linkedList.get(i)[0];
            end = linkedList.get(i)[1];
        }
        result.add(linkedList.get(linkedList.size() - 1));
        // Convert to array
        int[][] arrayResult = new int[result.size()][];
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }
}
