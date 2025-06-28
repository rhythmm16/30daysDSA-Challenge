import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty and current directory
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go back one directory
                }
            } else {
                stack.push(part); // Valid directory name
            }
        }

        // Build the simplified path
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // Return "/" if stack is empty (i.e., root)
        return result.length() > 0 ? result.toString() : "/";
    }
}
