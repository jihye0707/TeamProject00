package main.tree;

import java.util.ArrayList;

public class MyBST extends MyBinTree{
    ArrayList<MyBinNode> inOrderResult = new ArrayList<MyBinNode>();

    public MyBST() {
        super();
    }

    public MyBST(Object e){
        addRoot(e);
        root().setLeft(new MyBinNode());
        root().setRight(new MyBinNode());
    }

    private MyBinNode nextNode(MyBinNode v) {
        inOrderResult.clear();
        inOrder(root());
        int idx = 0;
        for (MyBinNode node : inOrderResult) {
            if(node == v){
                break;
            }
            else {
                idx+=1;
            }
        }
        if (idx<= inOrderResult.size()-2){
            return inOrderResult.get(idx+1);
        }
        return null;
    }

    private void inOrder(MyBinNode v){
        if(isExternal(v)){
            return;
        }
        inOrder(v.left());
        inOrderResult.add(v);
        inOrder(v.right());
    }

    public Object find(Object k) {
        MyBinNode findNode = search((int) k, root());
        if (isExternal(findNode)){
            return null;
        }
        return findNode;
    }

    private MyBinNode search(int k, MyBinNode v) {
        if (isExternal(v)) {
            return v;
        }
        if (k == (int) v.element()) {
            return v;
        }
        else if (k > (int) v.element()) {
            return search(k, v.right());
        }
        else if(k< (int) v.element()) {
            return search(k,v.left());
        }
        return null;
    }

    public ArrayList findAll(Object k) {
        ArrayList<MyBinNode> result = new ArrayList<>();
        MyBinNode curr = search((int) k,root());
        while (!isExternal(curr)){
            result.add(curr);
            curr = search((int) k, curr.left());
        }
        return result;
    }

    public Object insert(Object k) {
        MyBinNode searchNode = search((int) k, root());
        if(!isExternal(searchNode)){
            searchNode = search((int) k, searchNode.left());
        }
        MyBinNode parent = (MyBinNode) searchNode.parent();
        if (isLeftChild(searchNode)){
            parent.setLeft(searchNode);
        }
        else{
            parent.setRight(searchNode);
        }
        searchNode.setElement(k);
        searchNode.setLeft(new MyBinNode());
        searchNode.setRight(new MyBinNode());
        size++;
        return searchNode;
    }

    public boolean isLeftChild(MyBinNode v){
        MyBinNode parent = (MyBinNode) v.parent();
        if(v == parent.left()){
            return true;
        }
        return false;
    }

    public Object remove(Object k) {
//        ArrayList list = findAll(k);
        MyBinNode searchNode = search((int) k, root());
        if (isExternal(searchNode)) {
            return null;
        }
        if (searchNode == root()) {
            this.addRoot(root().left());
        }
        MyBinNode parent = (MyBinNode) searchNode.parent();
        if (isExternal(searchNode.left()) && isExternal(searchNode.right())) {       //자식이 없는 노드
            if (isLeftChild(searchNode)) {
                parent.setLeft(new MyBinNode());
            } else {
                parent.setRight(new MyBinNode());
            }
            return searchNode;
        } else {
            MyBinNode nextNode = nextNode(searchNode);
            nextNode.setParent(parent);
            if (isLeftChild(searchNode)) {
                parent.setLeft(nextNode);
            } else {
                parent.setRight(nextNode);
            }
        }
        return searchNode;
    }

    public void printInorder(MyBinNode v){
        if(isExternal(v)){
            return;
        }
        printInorder(v.left());
        System.out.printf(v.element() + " ");
        printInorder(v.right());
    }
}
