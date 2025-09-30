```java
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;  // position to write compressed chars
        int read = 0;   // position to scan chars

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;

            // Count consecutive same chars
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // new length of compressed array
    }
}
```
