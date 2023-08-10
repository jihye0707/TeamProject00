package main.pq;

import java.util.Comparator;

public class IntComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        return  (int)o1 - (int)o2;
    }
}
