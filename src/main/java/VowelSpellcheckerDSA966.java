
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class VowelSpellcheckerDSA966 {

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        int capacity = (int) (wordlist.length / 0.75f) + 1;
        Map<String, String> caseInsensitiveWords = new HashMap<>(capacity);
        Map<String, String> vowelErrorsWords = new HashMap<>(capacity);
        Set<String> exactMatch = new HashSet<>(capacity);

        for (String word : wordlist) {
            exactMatch.add(word);
            caseInsensitiveWords.putIfAbsent(word.toLowerCase(), word);
            vowelErrorsWords.putIfAbsent(devowel(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];
        String query = "";
        for (int i = 0; i < queries.length; i++) {
            query = queries[i];
            if (exactMatch.contains(queries[i])) {
                result[i] = queries[i];
                continue;
            }

            if (caseInsensitiveWords.containsKey(query.toLowerCase())) {
                result[i] = caseInsensitiveWords.get(query.toLowerCase());
                continue;
            }

            if (vowelErrorsWords.containsKey(devowel(query.toLowerCase()))) {
                result[i] = vowelErrorsWords.get(devowel(query.toLowerCase()));
                continue;
            }
            result[i] = "";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        String[] result = spellchecker(wordlist, queries);

        for(String r : result) {
            System.out.println(r);
        }

    }
}
