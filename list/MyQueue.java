package main.list;

public class MyQueue {

    private MyArrayList arrayList = new MyArrayList();

    public Integer size(){
        return arrayList.size();
    }

    public boolean isEmpty(){
        return arrayList.isEmpty();
    }

    public Object front(){
        return arrayList.get(0);
    }

    public void enqueue(Object e){
        arrayList.add(size(), e);
    }

    public Object dequeue(){
        try {
            return arrayList.remove(0);
        }catch (IndexOutOfBoundsException e){
            throw new RuntimeException("EmptyQueueException");
        }
    }
}
