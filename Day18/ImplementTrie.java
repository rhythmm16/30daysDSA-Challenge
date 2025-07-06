class Trie {

    // Node class to represent each character node
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // one for each lowercase letter
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }

    // Returns true if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEndOfWord;
    }

    // Returns true if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    // Helper function to find the node at the end of a given word/prefix
    private TrieNode find(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) {
                return null;
            }
            node = node.children[i];
        }
        return node;
    }
}
