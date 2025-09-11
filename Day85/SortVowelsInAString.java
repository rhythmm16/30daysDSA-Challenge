class Solution {
    public String sortVowels(String s) {
        // Step 1: collect all vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        // Step 2: sort the vowels by ASCII
        Collections.sort(vowels);

        // Step 3: rebuild string by placing sorted vowels back
        StringBuilder result = new StringBuilder();
        int idx = 0; // index for vowels list
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // helper to check if char is vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
