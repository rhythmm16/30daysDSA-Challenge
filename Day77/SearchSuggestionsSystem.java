import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        int n = products.length;
        String prefix = "";
        int left = 0, right = n - 1;
        
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            while (left <= right && !products[left].startsWith(prefix)) {
                if (products[left].compareTo(prefix) < 0) {
                    left++;
                } else {
                    break;
                }
            }
            while (left <= right && !products[right].startsWith(prefix)) {
                if (products[right].compareTo(prefix) > 0) {
                    right--;
                } else {
                    break;
                }
            }
            
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < 3 && left + i <= right; i++) {
                temp.add(products[left + i]);
            }
            result.add(temp);
        }
        
        return result;
    }
}
