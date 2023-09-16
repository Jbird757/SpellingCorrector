package spell;

import java.util.Arrays;

public class Trie implements ITrie {

    private final Node root = new Node();

    @Override
    public void add(String word) {
        word = word.toLowerCase();
        INode node = find(word);
        if (node != null) {
            node.incrementValue();
        } else { //Case word s not present in dictionary
            recursiveAdd(word, root);
        }
    }

    private void recursiveAdd(String word, INode node) {
        if (word.isEmpty()) {
            node.incrementValue();
            return;
        }
        var children = node.getChildren();
        int index = word.charAt(0) - 'a';
        if (children[index] == null) children[index] = new Node();
        recursiveAdd(word.substring(1), children[index]);
    }

    @Override
    public INode find(String word) {
        word = word.toLowerCase();
        return findInTrie(root, word);
    }

    private INode findInTrie(INode node, String word) {
        if (node == null) {
            return null;
        }
        if (word.isEmpty()) {
            if (node.getValue() > 0) {
                return node;
            }
            return null;
        }
        int index = word.charAt(0) - 'a';
        var nextNode = node.getChildren()[index];
        return findInTrie(nextNode, word.substring(1));
    }

    @Override
    public int getWordCount() {
        int count = 0;
        count += recursiveWordCount(root, count);
        return count;
    }

    private int recursiveWordCount(INode node, int wordCount) {
        if (node.getValue() > 0) {
            wordCount++;
        }
        for (INode child : node.getChildren()) {
            if (child != null) {
                wordCount = recursiveWordCount(child, wordCount);
            }
        }
        return wordCount;
    }

    @Override
    public int getNodeCount() {
        int count = 0;
        count += recursiveNodeCount(root, count);
        return count;
    }

    private int recursiveNodeCount(INode node, int nodeCount) {
        nodeCount++;
        for (INode child : node.getChildren()) {
            if (child != null) {
                nodeCount = recursiveNodeCount(child, nodeCount);
            }
        }
        return nodeCount;
    }

    @Override
    public String toString() {
        StringBuilder curWord = new StringBuilder();
        StringBuilder output = new StringBuilder();
        toStringHelper(root, curWord, output);
        return output.toString();
    }

    private void toStringHelper(INode node, StringBuilder word, StringBuilder output) {
        if (node.getValue() > 0) {
            output.append(word.toString());
            output.append("\n");
        }
        for (int i = 0; i < node.getChildren().length; i++) {
            INode child = node.getChildren()[i];
            if (child != null) {
                char childChar = (char) ('a' + i);
                word.append(childChar);
                toStringHelper(child, word, output);

                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trie newTrie = (Trie) o;
        return equalsHelper(root, newTrie.root);
    }

    private boolean equalsHelper(INode n1, INode n2) {
        if (n1 == n2) return true;
        if (n1.getValue() != n2.getValue() || !Arrays.equals(n1.getChildren(), n2.getChildren())) return false;
        //Bug around here
        for (int i = 0; i < n1.getChildren().length; i++) {
            equalsHelper(n1.getChildren()[i], n2.getChildren()[i]);
        }
        return true;
    }

    @Override
    public int hashCode() {
        return hashCodeHelper(root, 31);
    }

    private int hashCodeHelper(INode node, int result) {
        var children = node.getChildren();
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                result *= (i * 7) + (node.getValue() * i * 7);
                hashCodeHelper(children[i], result);
            }
        }
        return result;
    }
}
