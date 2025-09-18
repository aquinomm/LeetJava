class Solution {
    public boolean exactMatch(String original, String compare) {
        return original.equals(compare);
    }

    public boolean caseInsensitiveMatch(String original, String compare) {
        return original.equalsIgnoreCase(compare);
    }

    public boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public boolean vowelPositionMatch(String original, String compare) {
        boolean result = true;
        for (int i = 0; i < original.length() && result; i++) {
            char o = original.charAt(i);
            char c = compare.charAt(i);
            if (isVowel(o) && !isVowel(c) ||
                !isVowel(o) && isVowel(c)
            ) 
                result = false;
                
            if (!isVowel(o) && !isVowel(c) && Character.toLowerCase(o) != Character.toLowerCase(c)) 
                result = false;
        }
        return result;
    }

    public String queryMatchesWordlist(String[] wordlist, String query) {
        for(String word: wordlist) {
            if (exactMatch(word, query)) return word;
        }

        for(String word: wordlist) {
            if (caseInsensitiveMatch(word, query)) return word;
        }

        for(String word: wordlist) {
            if (vowelPositionMatch(word, query)) return word;
        }

        return "";
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] result = new String[queries.length];
        for(int i = 0; i < queries.length; i++) {
            result[i] = queryMatchesWordlist(wordlist, queries[i]);
        }
        return result;
    }
}