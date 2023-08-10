package main.list;

public interface List {
    public Object get(Integer i);

    public Object set(Integer i, Object e);

    public void add(Integer i, Object e);

    public Object remove(Integer i);

    public Integer size();

    public boolean isEmpty();
}
