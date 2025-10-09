class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // Move left pointer to next vowel
            while (left < right && !isVowel(chars[left])) left++;
            // Move right pointer to previous vowel
            while (left < right && !isVowel(chars[right])) right--;

            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
