package main.pq;

import java.util.ArrayList;
import java.util.Comparator;

public class MyPQ {

    private ArrayList<MyEntry> pq;
    private Comparator<Object> comparator;

    public MyPQ(Comparator comp) {
        pq = new ArrayList<>();
        comparator = comp;
    }

    public MyPQ(int initialCapacity, Comparator comp) {
        comparator = comp;
        pq = new ArrayList<>();
    }

    public int size() {
        return pq.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public MyEntry insert(Object k, Object v) {
        MyEntry insertEntry = new MyEntry(k,v);
        int idx=0;
        if (isEmpty()){
            pq.add(insertEntry);
        }
        else {
            for (MyEntry entry : pq) {
                if (comparator.compare(entry.getKey(), insertEntry.getKey()) >= 0) {
                    pq.add(idx, insertEntry);
                    break;
                } else {
                    idx++;
                    if(idx==pq.size()){
                        pq.add(insertEntry);
                        break;
                    }
                }
            }
        }
        return insertEntry;
    }

    public MyEntry removeMin() {
        return pq.remove(0);
    }

    public MyEntry min() {
        return pq.get(0);
    }

}
