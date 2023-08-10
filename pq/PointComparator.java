package main.pq;

import java.util.Comparator;
import java.awt.Point;

import static java.lang.Math.*;

public class PointComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        Point p1 = new Point((Point) o1);
        Point p2 = new Point((Point) o2);
        int d1 = (int) sqrt((pow(p1.x,2) + pow(p1.y,2)));
        int d2 = (int) sqrt((pow(p2.x,2) + pow(p2.y,2)));

        return d1-d2;
    }
}
