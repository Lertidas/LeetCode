import java.util.ArrayList;
import java.util.List;

public class Problem68 {
    public String solve() {
        String[] words = new String[]{"Science","is","what","we",
                "understand","well","enough","to","explain","to",
                "a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> result = fullJustify(words, maxWidth);
        for (String word : result) {
            System.out.println(word);
        }
        return result.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = 0;
        List<String> currentWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() + n > maxWidth) {
                result.add(getLine(currentWords, maxWidth, false));
                currentWords.clear();
                n = 0;
            }
            currentWords.add(word);
            n += (word.length() + 1);
        }
        // Add final line
        if (n != 0) {
            result.add(getLine(currentWords, maxWidth, true));
        }
        return result;
    }

    private String getLine(List<String> words, int maxWidth, boolean last) {
        int n = 0;
        StringBuilder sb = new StringBuilder();
        if (last || words.size() == 1) {
            for (String word : words) {
                sb.append(word);
                n += word.length();
                if (n != maxWidth) {
                    sb.append(' ');
                    n += 1;
                }
            }
            sb.append(" ".repeat(maxWidth - n));
        }
        else {
            int wordsLength = 0;
            for (String word : words) {
                wordsLength += word.length();
            }
            // Size
            int size = (maxWidth - wordsLength) / (words.size() - 1);
            int extra = (maxWidth - wordsLength) % (words.size() - 1);
            // Add in words and spaces
            for (int i = 0; i < words.size(); i++) {
                sb.append(words.get(i));
                if (i != words.size() - 1) {
                    if (i < extra) {
                        sb.append(" ".repeat(size + 1));
                    }
                    else {
                        sb.append(" ".repeat(size));
                    }
                }
            }
        }
        return sb.toString();
    }
}
