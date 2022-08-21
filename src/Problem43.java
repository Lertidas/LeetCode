import java.util.Arrays;

public class Problem43 {
    public String solve() {
        String num1 = "123";
        String num2 = "456";
        return multiply(num1, num2);
    }
    public String multiply(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            a[i] = getInt(num1.charAt(num1.length() - i - 1));
        }
        for (int j = 0; j < num2.length(); j++) {
            b[j] = getInt(num2.charAt(num2.length() - j - 1));
        }
        // Create answer array
        int[] answer = new int[a.length + b.length];
        // Perform multiplication
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                performMultiplaction(a[i], b[j], i, j, answer);
            }
        }
        // Build String result
        StringBuilder sb = new StringBuilder();
        for (int i = answer.length - 1; i >= 0; i--) {
            if (!(sb.length() == 0 && answer[i] == 0 && i != 0)) {
                sb.append(answer[i]);
            }
        }
        return sb.toString();
    }
    private void performMultiplaction(int a, int b, int aPos, int bPos, int[] answer) {
        int pos = aPos + bPos;
        int c = a * b;
        int d1 = c % 10;
        int d2 = c / 10;
        addValueToAnswer(d1, pos, answer);
        if (d2 != 0) {
            addValueToAnswer(d2, pos + 1, answer);
        }
    }
    private void addValueToAnswer(int c, int pos, int[] answer) {
        int a = c + answer[pos];
        if (a >= 10) {
            answer[pos] = a % 10;
            addValueToAnswer(a / 10, pos + 1, answer);
        }
        else {
            answer[pos] = a;
        }
    }
    private int getInt(char c) {
        switch (c) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }
}
