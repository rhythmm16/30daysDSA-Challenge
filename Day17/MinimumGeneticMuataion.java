class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        if (!geneBank.contains(endGene)) return -1;

        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                if (current.equals(endGene)) return level;

                char[] currArr = current.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char original = currArr[i];
                    for (char c : genes) {
                        currArr[i] = c;
                        String mutated = new String(currArr);
                        if (!visited.contains(mutated) && geneBank.contains(mutated)) {
                            queue.offer(mutated);
                            visited.add(mutated);
                        }
                    }
                    currArr[i] = original; // restore original gene
                }
            }
            level++;
        }

        return -1; // Not reachable
    }
}
