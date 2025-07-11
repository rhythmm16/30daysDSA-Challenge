class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();  // To store the final binary result
        int i = a.length() - 1;  // Pointer to the end of string a
        int j = b.length() - 1;  // Pointer to the end of string b
        int carry = 0;           // Initial carry is 0

        // Iterate while either string has digits left or there's a carry
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;  // Start with carry from last operation

            if (i >= 0) {
                sum += a.charAt(i--) - '0';  // Convert char to int and add to sum
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';  // Convert char to int and add to sum
            }

            result.append(sum % 2);  // Append current binary digit (0 or 1)
            carry = sum / 2;         // Calculate carry for next iteration
        }

        return result.reverse().toString();  // Binary string is in reverse, so reverse it back
    }
}
