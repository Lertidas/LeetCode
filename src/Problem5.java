public class Problem5 {
    public String solve() {
        return longestPalindrome("\"jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel\"");
    }
    public String longestPalindrome(String s) {
        // Setup variables
        int n = s.length();
        String pal = "";
        int maxSize = 0;
        int l, r;
        // Check for all palindromes
        for (int middle = 0; middle < n; middle++) {
            // Odd Case
            l = middle - 1;
            r = middle + 1;
            while (isPalindrome(l, r, s, n)) {
                l -= 1;
                r += 1;
            }
            l += 1;
            r -= 1;
            // Check if max palindrome should be updated
            if (1 + (r - l) > maxSize) {
                pal = s.substring(l, r + 1);
                maxSize = 1 + (r - l);
            }
            // Even Case
            l = middle;
            r = middle + 1;
            while (isPalindrome(l, r, s, n)) {
                l -= 1;
                r += 1;
            }
            l += 1;
            r -= 1;
            // Check if max palindrome should be updated
            if (1 + (r - l) > maxSize) {
                pal = s.substring(l, r + 1);
                maxSize = 1 + (r - l);
            }
        }
        return pal;
    }
    private boolean isPalindrome(int a, int b, String s, int n) {
        if (a < 0 || b >= n) {
            return false;
        }
        else {
            return s.charAt(a) == s.charAt(b);
        }
    }
}
