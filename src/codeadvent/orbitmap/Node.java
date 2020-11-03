package codeadvent.orbitmap;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Node parent;
    private List<Node> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        child.setParent(this);
        children.add(child);
    }



}
