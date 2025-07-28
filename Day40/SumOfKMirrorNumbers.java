class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            // Generate all palindromic numbers of current length
            for (long num : generatePalindromes(length)) {
                if (isKPalindrome(num, k)) {
                    sum += num;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }

        return sum;
    }

    // Generate palindromes of a given length in base-10
    private List<Long> generatePalindromes(int length) {
        List<Long> palindromes = new ArrayList<>();

        // Half length for constructing palindromes
        int halfLen = (length + 1) / 2;
        long start = (long) Math.pow(10, halfLen - 1);
        long end = (long) Math.pow(10, halfLen);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            String secondHalf = new StringBuilder(firstHalf.substring(0, length % 2 == 0 ? firstHalf.length() : firstHalf.length() - 1)).reverse().toString();
            String fullPalin = firstHalf + secondHalf;
            palindromes.add(Long.parseLong(fullPalin));
        }

        return palindromes;
    }

    // Check if a number is a palindrome in base-k
    private boolean isKPalindrome(long num, int k) {
        String baseK = toBaseK(num, k);
        int left = 0, right = baseK.length() - 1;
        while (left < right) {
            if (baseK.charAt(left++) != baseK.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // Convert a number to base-k as a string
    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.toString();
    }
}
