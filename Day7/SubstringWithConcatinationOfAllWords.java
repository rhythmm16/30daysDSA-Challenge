import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLength * wordCount;

        // Frequency map of words
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words)
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

        // Slide over s in wordLength steps
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                // If word is part of the target words
                if (wordMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if frequency is too high
                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }

                    // If all words matched
                    if (count == wordCount)
                        result.add(left);

                } else {
                    // Reset if the word is not in the words array
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
