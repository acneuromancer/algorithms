import java.util.Iterator;
import java.util.LinkedList;

public class Trie {

    /**
     * Represents a node in the trie
     */
    private class TrieNode {
        private char data;
        private boolean isEnd;
        private int count;
        private LinkedList<TrieNode> childList;

        public TrieNode(char c) {
            childList = new LinkedList<>();
            isEnd = false;
            data = c;
            count = 0;
        }

        public TrieNode getChild(char c) {
            if (childList != null) {
                for (TrieNode child : childList) {
                    if (child.data == c) {
                        return child;
                    }
                }
            }

            return null;
        }

        @Override
        public String toString() {
            return data + ": " + childList;
        }
    }

    private TrieNode root;

    /**
     * Constructor: Create a new trie with a root which contains a space character
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    public TrieNode getRoot() {
        return root;
    }

    /**
     * Insert a word in the trie
     * @param word the word to insert
     */
    public void insert(String word) {
        if (search(word)) {
            return;
        }

        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child != null) {
                current = child;
            } else {
                current.childList.add(new TrieNode(ch));
                current = current.getChild(ch);
            }
            current.count++;
        }

        current.isEnd = true;
    }

    /**
     * Search a word in a Trie
     * @param word the word to search
     * @return true if the trie contains the word, false if it does not
     */
    public boolean search(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null) {
                return false;
            }

            current = current.getChild(ch);
        }

        return current.isEnd == true;
    }

    /**
     * Remove a word from the trie
     * @param word
     * @return true or false depending whether the trie contains the word or not
     */
    public boolean remove(String word) {
        if (search(word) == false) {
            return false;
        }

        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);

            if (child.count == 1) {
                current.childList.remove(child);
                return true;
            }

            --child.count;
            current = child;
        }

        current.isEnd = false;
        return false;
    }

    /**
     * Print all words in the trie
     */
    public void printAllWords() {
        printAllWords(this.root, "");
    }

    /**
     * Private helper function for the public printAllWords() method.
     * @param root
     * @param s
     */
    private void printAllWords(TrieNode root, String s) {
        TrieNode current = root;

        if (root.childList == null || root.childList.size() == 0) {
            return;
        }

        Iterator<TrieNode> iter = current.childList.iterator();
        while(iter.hasNext()) {
            TrieNode node = iter.next();
            s += node.data;

            printAllWords(node, s);

            if (node.isEnd == true) {
                System.out.println(" " + s);
            }

            s = s.substring(0, s.length()-1);
        }
    }

}
