import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 means +, -1 means -

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
                // Check for integer overflow
                if (number < 0) {
                    throw new ArithmeticException("Integer overflow");
                }
            } else if (ch == '+' || ch == '-') {
                result += sign * number;
                number = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '(') {
                // Save the current result and sign
                stack.push(result);
                stack.push(sign);
                // Reset for calculation inside parentheses
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                // Apply the sign from before the parentheses
                result *= stack.pop();
                // Add the result from before the parentheses
                result += stack.pop();
            }
            // Skip spaces
        }

        // Handle the last number if exists
        return result + (sign * number);
    }
}
