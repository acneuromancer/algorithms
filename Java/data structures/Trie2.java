import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie2 {

    private class TrieNode {
        private Character character;
        private boolean isEnd;
        private Map<Character, TrieNode> children;

        TrieNode(Character c) {
            this.character = c;
            this.isEnd = false;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;
    private List<String> output;

    public Trie2() {
        root = new TrieNode(null);
    }

    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.isEnd = true;
    }

    public List<List<String>> printTrie() {
        List<List<String>> result = new ArrayList<>();

        for (TrieNode n : this.root.children.values()) {
            result.add(search(n.character.toString()));
        }

        return result;
    }

    public List<String> search(String prefix) {
        TrieNode node = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                return null;
            }
        }

        this.output = new ArrayList<>();
        dfs(node, prefix.substring(0, prefix.length() - 1));

        return output;
    }

    private void dfs(TrieNode node, String prefix) {
        if (node.isEnd) {
            this.output.add(prefix + node.character);
        }

        for (TrieNode n : node.children.values()) {
            dfs(n, prefix + node.character);
        }
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("he");
        trie.insert("how");
        trie.insert("window");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("win");
        System.out.println(trie.printTrie());
    }

}
