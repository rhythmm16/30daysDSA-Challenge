class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 means +, -1 means -

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // Push current result and sign to stack for later
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();      // sign before parenthesis
                result += stack.pop();      // result calculated before parenthesis
            }
            // ignore spaces
        }

        // Add any remaining number
        if (number != 0) result += sign * number;

        return result;
    }
}
