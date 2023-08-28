import java.util.Arrays;

public class Problem75 implements Problem {

    @Override
    public String solve() {
        int[] test = new int[]{2,1};
        sortColors(test);
        return Arrays.toString(test);
    }

    public void sortColors(int[] nums) {
        int[] counts = getColorCounts(nums);
        int zeroPos = getZeroPos(counts);
        int onePos = getOnePos(counts);
        int twoPos = getTwoPos(counts);
        if (zeroPos >= 0) {
            for (int i = zeroPos; i < onePos; i++) {
                nums[i] = 0;
            }
        }
        if (onePos >= 0) {
            for (int i = onePos; i < twoPos; i++) {
                nums[i] = 1;
            }
        }
        if (twoPos >= 0) {
            for (int i = twoPos; i < nums.length; i++) {
                nums[i] = 2;
            }
        }
    }

    public int[] getColorCounts(int[] nums) {
        int[] counts = new int[]{0, 0, 0};
        for (int number : nums) {
            counts[number] += 1;
        }
        return counts;
    }

    public int getZeroPos(int[] counts) {
        return counts[0] > 0 ? 0 : -1;
    }

    public int getOnePos(int[] counts) {
        return counts[0] + counts[1] > 0 ? counts[0] : -1;
    }

    public int getTwoPos(int[] counts) {
        return counts[0] + counts[1] + counts[2] > 0 ? counts[0] + counts[1] : -1;
    }
}
