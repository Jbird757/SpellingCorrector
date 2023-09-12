package spell;

public class Trie implements ITrie {

    private INode root = new Node();

    @Override
    public void add(String word) {
        word = word.toLowerCase();
        INode node = find(word);
        if (node != null) {
            node.incrementValue();
        } else {
            var children = root.getChildren();
            var chars = word.toCharArray();
            for (var i = 0; i < word.length(); i++) {
                var childPos = chars[i] - 'a';
                var childNode = children[childPos];
                if (childNode == null) {
                    var j = 1; //replace
                }
            }
        }
    }

    @Override
    public INode find(String word) {
        return null;
    }

    @Override
    public int getWordCount() {
        return 0;
    }

    @Override
    public int getNodeCount() {
        int count = 1;
        
        return 0;
    }
}
