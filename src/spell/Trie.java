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
        word = word.toLowerCase();
        int index = word.charAt(0) - 'a';
        var nextNode = root.children[index];
        while (nextNode != null) {
            word = word.substring(1);
            nextNode = traverseTrie(nextNode, word);
        }



        /*
        1. Start at root  ***
        2. Check if root child exists for first letter ***
        3. Go to root child ***
        4. Pop off first letter of word ***
        5. Check if next node child exists for new first letter
        6. Go to next node child
        7. Repeat steps 4-6 until word is finished
         */
        return null;
    }

    private INode traverseTrie(INode node, String word) {
        if (word == null) {
            return null;
        }
        int index = word.charAt(0) - 'a';
        var nextNode = node.children[index];
        return nextnode;
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
