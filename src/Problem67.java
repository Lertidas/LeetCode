public class Problem67 {
    public String solve() {
        String a = "1";
        String b = "111";
        return addBinary(a, b);
    }
    public String addBinary(String a, String b) {
        int n;
        int m;
        int difference;
        String larger;
        String smaller;
        if (a.length() >= b.length()) {
            n = a.length();
            m = b.length();
            larger = a;
            smaller = b;
        }
        else {
            n = b.length();
            m = a.length();
            larger = b;
            smaller = a;
        }
        difference = n - m;
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        for (int i = n - 1; i >= 0; i--) {
            if ((n - i - 1) >= m) {
                switch (larger.charAt(i)) {
                    case '0':
                        if (carry) {
                            sb.append('1');
                        }
                        else {
                            sb.append('0');
                        }
                        carry = false;
                        break;
                    case '1':
                        if (carry) {
                            sb.append('0');
                        }
                        else {
                            sb.append('1');
                        }
                        break;
                }
            }
            else {
                switch (larger.charAt(i)) {
                    case '0':
                        switch (smaller.charAt(i - difference)) {
                            case '0':
                                if (carry) {
                                    sb.append('1');
                                }
                                else {
                                    sb.append('0');
                                }
                                carry = false;
                                break;
                            case '1':
                                if (carry) {
                                    sb.append('0');
                                }
                                else {
                                    sb.append('1');
                                }
                                break;
                        }
                        break;
                    case '1':
                        switch (smaller.charAt(i - difference)) {
                            case '0':
                                if (carry) {
                                    sb.append('0');
                                }
                                else {
                                    sb.append('1');
                                }
                                break;
                            case '1':
                                if (carry) {
                                    sb.append('1');
                                }
                                else {
                                    sb.append('0');
                                }
                                carry = true;
                                break;
                        }
                        break;
                }
            }
        }
        if (carry) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
