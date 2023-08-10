package main.list;

import java.util.EmptyStackException;

public class MyStack {
    private MyArrayList arrayList = new MyArrayList();

    public Integer size() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public void push(Object e) {
            arrayList.add(arrayList.size(), e);
    }

    public Object pop() {
        try {
            return arrayList.remove(arrayList.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    public Object top(){
        return arrayList.get(arrayList.size()-1);
    }
}
