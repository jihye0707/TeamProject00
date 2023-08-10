package main.tree;
import java.util.ArrayList;

public class MyTree {

    protected int size;
    private MyNode root;

    public MyTree() {
        root = null;
        size = 0;
    }

    public MyTree(Object e) {
        root = new MyNode(e);
        root.setChildren(new ArrayList());
        size = 1;
    }

    public int size() {
        return size;
    }

    public MyNode root() {
        return root;
    }

    public ArrayList children(MyNode v){
        return v.children();
    }

    public boolean isExternal(MyNode v) {
        return v.children().isEmpty();
    }

    public MyNode addRoot(Object e){
        MyNode newRoot = new MyNode(e);
        newRoot.setChildren(new ArrayList());
        if (root == null) {
            root = newRoot;
            size++;
        }
        return newRoot;
    }

    public MyNode addNode(Object e) {
        MyNode newNode = new MyNode(e);
        newNode.setChildren(new ArrayList());
        newNode.setParent(root);
        root.children().add(newNode);
        size++;
        return newNode;
    }

    public MyNode addChild(MyNode v, Object e) {
        MyNode newNode = new MyNode(e);
        newNode.setChildren(new ArrayList());
        newNode.setParent(v);
        v.children().add(newNode);
        size++;
        return newNode;
    }

    public MyNode addChild(MyNode v, int i, Object e) {
        MyNode newNode = new MyNode(e);
        newNode.setChildren(new ArrayList());
        newNode.setParent(v);
        v.children().add(i,newNode);
        size++;
        return newNode;
    }

    public MyNode removeChild(MyNode v, int i) {
        MyNode rmNode = (MyNode) v.children().remove(i);
        size --;
        return rmNode;
    }

}
