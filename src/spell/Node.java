package spell;

import java.util.Arrays;

public class Node implements INode {
    private int count = 0;
    private final INode[] children = new INode[26];

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return count == node.count && Arrays.equals(children, node.children);
    }

    @Override
    public int hashCode() {
        int result = count + 1;
        for (var child : children) {
            if (child != null) {
                result += count;
            }
        }
        result = 31 * result;
        return result;
    }
}
