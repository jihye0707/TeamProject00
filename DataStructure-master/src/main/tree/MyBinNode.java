package main.tree;

import java.util.ArrayList;
import java.util.List;

public class MyBinNode extends MyNode {

    public MyBinNode() {
        super();
    }

    public MyBinNode(Object e) {
        super(e);
    }

    public MyBinNode left() {
        if (children() == null){
            return null;
        }
        else {
            return (MyBinNode) children().get(0);
        }
    }

    public MyBinNode right() {
        if (children() == null || children().size()==1){
            return null;
        }
        else {
            return (MyBinNode) children().get(1);
        }
    }

    public void setLeft(MyBinNode v) {
        if (this.children() == null){
            ArrayList<MyBinNode> arrayList = new ArrayList<>();
            arrayList.add(0,v);
            this.setChildren(arrayList);
        }else{
            this.children().set(0,v);
        }
        if (v != null){
            v.setParent(this);
        }
    }

    public void setRight(MyBinNode v) {
        if (this.children() == null){
            ArrayList<MyBinNode> arrayList = new ArrayList<>();
            arrayList.add(0,null);
            arrayList.add(1,v);
            this.setChildren(arrayList);
        }else{
            if (children().size()>=2) {
                this.children().set(1, v);
            }
            else{
                this.children().add(1,v);
            }
        }
        if (v != null){
            v.setParent(this);
        }
    }
}
