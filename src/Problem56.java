import java.util.Arrays;

public class Problem56 {
    public String solve() {
//        int[][] intervals = new int[4][];
//        intervals[0] = new int[]{1, 3};
//        intervals[1] = new int[]{2, 6};
//        intervals[2] = new int[]{8, 10};
//        intervals[3] = new int[]{15, 18};

//        int[][] intervals = new int[2][];
//        intervals[0] = new int[]{1, 4};
//        intervals[1] = new int[]{4, 5};

//        int[][] intervals = new int[][]{new int[]{362,367},new int[]{314,315},new int[]{133,138},
//        new int[]{434,443},new int[]{202,203},new int[]{144,145},new int[]{229,235},new int[]{205,212},
//        new int[]{314,323},new int[]{128,129},new int[]{413,414},new int[]{342,345},new int[]{43,49},
//        new int[]{333,342},new int[]{173,178},new int[]{386,391},new int[]{131,133},new int[]{157,163},
//        new int[]{187,190},new int[]{186,186},new int[]{17,19},new int[]{63,69},new int[]{70,79},
//        new int[]{386,391},new int[]{98,102},new int[]{236,239},new int[]{195,195},new int[]{338,338},
//        new int[]{169,170},new int[]{151,153},new int[]{409,416},new int[]{377,377},new int[]{90,96},
//        new int[]{156,165},new int[]{182,186},new int[]{371,372},new int[]{228,233},new int[]{297,306},
//        new int[]{56,61},new int[]{184,190},new int[]{401,403},new int[]{221,228},new int[]{203,212},
//        new int[]{39,43},new int[]{83,84},new int[]{66,68},new int[]{80,83},new int[]{32,32},
//        new int[]{182,182},new int[]{300,306},new int[]{235,238},new int[]{267,272},new int[]{458,464},
//        new int[]{114,120},new int[]{452,452},new int[]{372,375},new int[]{275,280},new int[]{302,302},
//        new int[]{5,9},new int[]{54,62},new int[]{237,237},new int[]{432,439},new int[]{415,421},
//        new int[]{340,347},new int[]{356,358},new int[]{165,168},new int[]{15,17},new int[]{259,265},
//        new int[]{201,204},new int[]{192,197},new int[]{376,383},new int[]{210,211},new int[]{362,367},
//        new int[]{481,488},new int[]{59,64},new int[]{307,315},new int[]{155,164},new int[]{465,467},
//        new int[]{55,60},new int[]{20,24},new int[]{297,304},new int[]{207,210},new int[]{322,328},
//        new int[]{139,142},new int[]{192,195},new int[]{28,36},new int[]{100,108},new int[]{71,76},
//        new int[]{103,105},new int[]{34,38},new int[]{439,441},new int[]{162,168},new int[]{433,433},
//        new int[]{368,369},new int[]{137,137},new int[]{105,112},new int[]{278,280},new int[]{452,452},
//        new int[]{131,132},new int[]{475,480},new int[]{126,129},new int[]{95,104},new int[]{93,99},
//        new int[]{394,403},new int[]{70,78}};

        int[][] intervals = new int[5][];
        intervals[0] = new int[]{2, 3};
        intervals[1] = new int[]{4, 5};
        intervals[2] = new int[]{6, 7};
        intervals[3] = new int[]{8, 9};
        intervals[4] = new int[]{1, 10};

        return Arrays.deepToString(merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        Node start = new Node(null, null, null);
        for (int[] ints : intervals) {
            Interval interval = new Interval(ints[0], ints[1]);
            Node current = start;
            boolean flag = true;
            while (current.hasNext() && flag) {
                Result res = current.getNext().value.checkInterval(interval);
                switch (res) {
                    case ENTERED:
                        flag = false;
                        break;
                    case LESS:
                        flag = false;
                        current.getNext().insertBefore(interval);
                        break;
                    case GREATER:
                        current = current.getNext();
                        break;
                }
            }
            if (flag) {
                current.insertAfter(interval);
            }
        }
        Node current = start;
        // ADDED : Merge results
        while (current.hasNext()) {
            if (current.getValue() != null) {
                while (current.next != null &&
                        current.next.getValue().start <= current.getValue().end &&
                        current.next.getValue().start >= current.getValue().start) {
                    if (current.next.getValue().end > current.getValue().end) {
                        current.getValue().end = current.next.getValue().end;
                    }
                    current.next = current.getNext().getNext();
                }
            }
            if (current.hasNext()) {
                current = current.getNext();
            }
        }
        // Convert Node to int[][]
        int[][] result = new int[start.getLength()][];
        int counter = 0;
        // Add in values
        while (start.hasNext()) {
            start = start.getNext();
            result[counter++] = new int[]{start.getValue().start, start.getValue().end};
        }
        return result;
    }
    private class Node {
        private Node next;
        private Node prev;
        private Interval value;
        public Node getNext() {
            return next;
        }
        public Node getPrev() {
            return prev;
        }
        public Interval getValue() {
            return value;
        }
        public boolean hasNext() {
            return next != null;
        }
        public boolean hasPrev() {
            return prev != null;
        }
        public Node(Interval interval, Node prev, Node next) {
            this.value = interval;
            this.prev = prev;
            this.next = next;
        }
        // Insert Before
        public void insertBefore(Interval interval) {
            if (hasPrev()) {
                Node orig = this.prev;
                orig.next = new Node(interval, orig, this);
                this.prev = orig.next;
            }
            else {
                this.prev = new Node(interval, null, this);
            }
        }
        // Insert After
        public void insertAfter(Interval interval) {
            if (hasNext()) {
                Node orig = this.next;
                orig.prev = new Node(interval, this, orig);
                this.next = orig.prev;
            }
            else {
                this.next = new Node(interval, this, null);
            }
        }
        // Count
        public int getLength() {
            int count = 0;
            Node current = this;
            while (current.hasNext()) {
                count += 1;
                current = current.getNext();
            }
            return count;
        }
    }
    private class Interval {
        private int start;
        private int end;
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
        public Result checkInterval(Interval toCheck) {
            if (toCheck.end < this.start) {
                return Result.LESS;
            }
            else  if (toCheck.start > this.end) {
                return Result.GREATER;
            }
            else {
                updateInterval(toCheck);
                return Result.ENTERED;
            }
        }
        private void updateInterval(Interval toAdd) {
            if (toAdd.start < this.start) {
                this.start = toAdd.start;
            }
            if (toAdd.end > this.end) {
                this.end = toAdd.end;
            }
        }
    }
    private enum Result {
        LESS,
        ENTERED,
        GREATER
    }
}
