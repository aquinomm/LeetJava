import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInAString2785 {

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);

        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex));
                vowelIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        String t = sortVowels(s);
        System.out.println(t);
    }
}
