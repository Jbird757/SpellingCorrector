package spell;

public class Trie implements ITrie {

    private final INode root = new Node();

    @Override
    public void add(String word) {
        word = word.toLowerCase();
        INode node = find(word);
        if (node != null) {
            node.incrementValue();
        } else {
            var children = root.getChildren();


        }
    }

    @Override
    public INode find(String word) {
        word = word.toLowerCase();
        return findInTrie(root, word);
    }

    private INode findInTrie(INode node, String word) {
        if (word.isEmpty()) {
            return node;
        }
        int index = word.charAt(0) - 'a';
        var nextNode = node.getChildren()[index];
        return findInTrie(nextNode, word.substring(1));
    }

    private int recursiveNodeCount(INode node, int nodeCount) {
        nodeCount++;
        for (INode child : node.getChildren()) {
            nodeCount = recursiveNodeCount(child, nodeCount);
        }
        return nodeCount;
    }

    private int recursiveWordCount(INode node, int wordCount) {
        if (node.getValue() > 0) {
            wordCount++;
        }
        for (INode child : node.getChildren()) {
            wordCount = recursiveWordCount(child, wordCount);
        }
        return wordCount;
    }


    @Override
    public int getWordCount() {
        int count = 1;
        count += recursiveWordCount(root, count);
        return count;
    }

    @Override
    public int getNodeCount() {
        int count = 1;
        count += recursiveNodeCount(root, count);
        return count;
    }
}
