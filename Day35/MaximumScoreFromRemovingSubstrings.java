class Solution {
    public int maximumGain(String s, int x, int y) {
        // Remove the more valuable pair first
        if (x > y) {
            return gain(s, 'a', 'b', x, y);
        } else {
            return gain(s, 'b', 'a', y, x);
        }
    }

    private int gain(String s, char first, char second, int high, int low) {
        Stack<Character> stack = new Stack<>();
        int total = 0;

        // Step 1: Remove high priority pairs (either "ab" or "ba")
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop();
                total += high;
            } else {
                stack.push(ch);
            }
        }

        // Reconstruct the leftover string
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        s = sb.reverse().toString();

        // Step 2: Remove low priority pairs in remaining string
        stack.clear();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == second && ch == first) {
                stack.pop();
                total += low;
            } else {
                stack.push(ch);
            }
        }

        return total;
    }
}
