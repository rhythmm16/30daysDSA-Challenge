class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String word = queue.poll();
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chs[i] = c;
                        String next = new String(chs);
                        if (next.equals(endWord)) return steps + 1;
                        if (wordSet.contains(next)) {
                            queue.offer(next);
                            wordSet.remove(next); // Avoid revisiting
                        }
                    }
                    chs[i] = old;
                }
            }
            steps++;
        }

        return 0;
    }
}
