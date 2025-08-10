class Solution {
    public boolean reorderedPowerOf2(int n) {
        String targetCount = digitCount(n);
        
        for (int i = 0; i < 31; i++) { // 2^0 to 2^30 (since 2^30 < 1e9)
            if (digitCount(1 << i).equals(targetCount)) {
                return true;
            }
        }
        
        return false;
    }
    
    private String digitCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return Arrays.toString(count); // convert to string for easy comparison
    }
}
