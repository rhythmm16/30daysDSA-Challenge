import java.util.*;

class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        // Comparator: higher freq first, tie-break by larger value
        Comparator<Integer> cmp = (a, b) -> {
            int fa = freq.getOrDefault(a, 0);
            int fb = freq.getOrDefault(b, 0);
            if (fa != fb) return Integer.compare(fb, fa);
            return Integer.compare(b, a);
        };

        TreeSet<Integer> top = new TreeSet<>(cmp);
        TreeSet<Integer> rest = new TreeSet<>(cmp);
        long sumTop = 0L;

        for (int i = 0; i < n; i++) {
            int add = nums[i];

            // --- ADDING element `add` ---
            int oldF = freq.getOrDefault(add, 0);
            if (oldF > 0) {
                // remove from whichever set it currently belongs to (using oldF)
                if (top.remove(add)) {
                    sumTop -= (long) add * oldF;
                } else {
                    rest.remove(add);
                }
            }

            int newF = oldF + 1;
            freq.put(add, newF);

            // insert into top first, then push worst out if size > x
            top.add(add);
            sumTop += (long) add * newF;

            if (top.size() > x) {
                Integer worst = top.pollLast();
                if (worst != null) {
                    sumTop -= (long) worst * freq.get(worst);
                    rest.add(worst);
                }
            }

            // --- REMOVAL (slide) when window exceeds k ---
            if (i >= k) {
                int out = nums[i - k];
                int fout = freq.get(out); // must exist > 0

                // remove 'out' from its current set using current freq (fout)
                if (top.remove(out)) {
                    sumTop -= (long) out * fout;
                } else {
                    rest.remove(out);
                }

                int newFout = fout - 1;
                if (newFout == 0) {
                    freq.remove(out);
                } else {
                    freq.put(out, newFout);
                    // reinsert into rest (we'll rebalance next)
                    rest.add(out);
                }

                // After removal, ensure top has exactly x elements (or as many as available)
                while (top.size() < x && !rest.isEmpty()) {
                    Integer best = rest.pollFirst();
                    top.add(best);
                    sumTop += (long) best * freq.get(best);
                }

                // Also handle the (rare) case where some in top might now be worse than some in rest:
                // Move best from rest to top if it ranks higher than top.last()
                if (!rest.isEmpty() && !top.isEmpty()) {
                    Integer candidate = rest.first();
                    Integer worstTop = top.last();
                    // compare by comparator: if candidate should be ahead of worstTop, swap
                    if (cmp.compare(candidate, worstTop) < 0) {
                        // candidate ranks higher (remember cmp returns negative if candidate > worstTop)
                        // but our cmp sorts descending (higher first), so check properly:
                        // We'll repeatedly swap while candidate outranks worstTop
                        while (!rest.isEmpty() && !top.isEmpty()) {
                            candidate = rest.first();
                            worstTop = top.last();
                            if (cmp.compare(candidate, worstTop) < 0) {
                                // move candidate into top
                                rest.pollFirst();
                                top.pollLast();
                                sumTop -= (long) worstTop * freq.get(worstTop);
                                sumTop += (long) candidate * freq.get(candidate);
                                top.add(candidate);
                                rest.add(worstTop);
                            } else break;
                        }
                    }
                }
            }

            // For the first windows that are complete, record answer
            if (i >= k - 1) {
                ans[i - k + 1] = sumTop;
            }
        }

        return ans;
    }
}
