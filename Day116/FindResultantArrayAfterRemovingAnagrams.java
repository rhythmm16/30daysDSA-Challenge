import java.util.*;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prevSorted = "";

        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            if (!sorted.equals(prevSorted)) {
                result.add(word);
                prevSorted = sorted;
            }
        }
        return result;
    }
}
