package spell;

public class Node implements INode {
    private int count = 0;
    private final INode[] children;

    public Node() {
        children = new INode[26];
    }

    @Override
    public int getValue() {
        return this.count;
    }

    @Override
    public void incrementValue() {
        this.count += 1;
    }

    @Override
    public INode[] getChildren() {
        return children;
    }
}
