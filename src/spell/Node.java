package spell;

import java.util.Arrays;
import java.util.Objects;

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
}


