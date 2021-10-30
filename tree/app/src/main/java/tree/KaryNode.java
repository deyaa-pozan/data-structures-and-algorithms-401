package tree;

import java.util.ArrayList;
import java.util.List;

public class KaryNode <T>{
    T value;
    List<KaryNode> children = new ArrayList<>();

    public KaryNode(T value) {
        this.value = value;
    }

    public void addChild(KaryNode ch) {
        this.children.add(ch);
    }

    @Override
    public String toString() {
        return "KaryNode{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }
}

