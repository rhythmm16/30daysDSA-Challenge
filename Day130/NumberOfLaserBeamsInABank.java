class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, beams = 0;
        
        for (String row : bank) {
            int devices = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') devices++;
            }
            
            if (devices > 0) {
                beams += prev * devices;
                prev = devices;
            }
        }
        
        return beams;
    }
}
