import java.util.LinkedList;

public class Problem42 {
    public String solve() {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        return String.valueOf(trap(height));
    }
    public int trap(int[] height) {
        LinkedList<Wall> lst = new LinkedList<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            if (lst.size() == 0) {
                if (height[i] != 0) {
                    // Add value to list
                    lst.addFirst(new Wall(height[i], i));
                }
            }
            else {
                int prevHeight = 0;
                int addedIndex = lst.size();
                for (int j = 0; j < lst.size(); j++) {
                    if (j == 0) {
                        prevHeight = lst.get(j).height;
                        if (prevHeight >= height[i]) {
                            addedIndex = 0;
                            break;
                        }
                    }
                    else {
                        // Check size
                        if (lst.get(j).height >= height[i]) {
                            // Calculate water
                            water += (height[i] - prevHeight) * (i - lst.get(j).pos - 1);
                            addedIndex = j;
                            break;
                        }
                        else {
                            // Calculate water
                            water += (lst.get(j).height - prevHeight) * (i - lst.get(j).pos - 1);
                        }
                        prevHeight = lst.get(j).height;
                    }
                }
                if (addedIndex < lst.size()) {
                    for (int a = 0; a < addedIndex; a++) {
                        lst.removeFirst();
                    }
                    lst.addFirst(new Wall(height[i], i));
                }
                else {
                    lst = new LinkedList<>();
                    lst.addFirst(new Wall(height[i], i));
                }
            }
        }
        return water;
    }
    private class Wall {
        public int height;
        public int pos;
        public Wall(int height, int pos) {
            this.height = height;
            this.pos = pos;
        }
    }
}

