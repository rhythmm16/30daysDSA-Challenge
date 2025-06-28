class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // If token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();  // right operand
                int a = stack.pop();  // left operand
                int result = 0;

                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;  // integer division truncates toward 0
                }

                stack.push(result);
            } else {
                // If token is a number
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();  // final result
    }
}
