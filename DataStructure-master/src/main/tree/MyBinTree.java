package main.tree;

import java.util.ArrayList;

public class MyBinTree extends MyTree {

   private MyBinNode root;

    public MyBinTree() {
        super();
        root = null;
    }

    public MyBinTree(Object e) {
        super(e);
        root = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isRoot(MyBinNode v) {
        return v == root();
    }

    public boolean isInternal(MyBinNode v){
       return hasLeft(v)||hasRight(v);
    }

    public boolean isExternal(MyBinNode v) {
        return (!hasLeft(v) && !hasRight(v));
    }

    public MyBinNode root() {
        return root;
    }

    public MyBinNode parent(MyBinNode v) {
        return (MyBinNode) v.parent;
    }

    public MyBinNode left(MyBinNode v) {
        return v.left();
    }

    public MyBinNode right(MyBinNode v) {
        return v.right();
    }

    public boolean hasLeft(MyBinNode v) {
        return v.left() != null;
    }

    public boolean hasRight(MyBinNode v) {
        return v.right() != null;
    }

    public MyBinNode addRoot(Object e) {
        MyBinNode newRoot = new MyBinNode(e);
//        newRoot.setChildren(new ArrayList());
        if (root == null) {
            root = newRoot;
            size++;
        }
        return newRoot;
    }

    public MyBinNode addNode(Object e) {
        size++;
        return new MyBinNode(e);
    }

    public MyBinNode insertLeft(MyBinNode v, Object e) {
        MyBinNode newNode = new MyBinNode(e);
        v.setLeft(newNode);
        return newNode;
    }

    public MyBinNode insertRight(MyBinNode v, Object e) {
        MyBinNode newNode = new MyBinNode(e);
        v.setRight(newNode);
        return newNode;
    }

    public Object replace(MyBinNode v, Object e) {
        v.setElement(e);
        return e;
    }

    //본인(v)이 삭제되는거고 본인 자식 둘일 때 에러 냄
    public MyBinNode remove(MyBinNode v) throws TwoChildrenException {
        //v의 자식이 둘일때
        if (hasLeft(v)&&hasRight(v)) {
            throw new TwoChildrenException("자식이 두명인 노드는 삭제할 수 없습니다.");
        }
        //v가 왼쪽 자식만 있을 때
        else if(hasLeft(v)&&!hasRight(v)){
            MyBinNode parent = parent(v);
            MyBinNode child = v.left();
            if (v == parent.left()) {
                parent.setLeft(child);
                child.setParent(parent);
            }
            else{
                parent.setRight(child);
                child.setParent(parent);
            }
        }
        //v가 오른쪽 자식만 있을 때
        else if(!hasLeft(v)&&hasRight(v)){
            MyBinNode parent = parent(v);
            MyBinNode child = v.right();
            if (v == parent.left()) {
                parent.setLeft(child);
                child.setParent(parent);
            }
            else{
                parent.setRight(child);
                child.setParent(parent);
            }
        }
        //v가 자식이 없을 때
        else{
            MyBinNode parent = parent(v);
            if (v == parent.left()) {
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
        }
        size--;
        return v;
    }

    //v노드 왼쪽 오른쪽 자식으로 각각 t1,t2 삽입 이떄 v노드에 자식이 차있으면 예외
    public void attach(MyBinNode v, MyBinNode t1, MyBinNode t2) throws NotExternalException {
        if(!isExternal(v)){
            throw new NotExternalException("external 노드가 아닙니다.");
        }
        else {
            v.setLeft(t1);
            v.setRight(t2);
            t1.setParent(v);
            t2.setParent(v);
        }
    }

}
