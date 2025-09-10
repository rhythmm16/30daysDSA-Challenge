import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        // store languages known by each user in a set for quick lookup
        Set<Integer>[] userLang = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            userLang[i] = new HashSet<>();
            for (int lang : languages[i - 1]) {
                userLang[i].add(lang);
            }
        }
        
        // find pairs of friends that cannot communicate
        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0], v = f[1];
            boolean canCommunicate = false;
            for (int lang : userLang[u]) {
                if (userLang[v].contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }
        
        if (needTeach.isEmpty()) return 0; // already all can communicate
        
        // try teaching each language, count how many users in needTeach don’t know it
        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;
            for (int u : needTeach) {
                if (!userLang[u].contains(lang)) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}
