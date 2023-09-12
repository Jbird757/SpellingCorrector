package spell;

public class Node implements INode {
    private int count = 0;
    private INode[] children = new INode[26];

    @Override
    public int getValue() {
        return this.count;
    }

    @Override
    public void incrementValue() {
        this.count++;
    }

    @Override
    public INode[] getChildren() {
        return children;
    }
}
