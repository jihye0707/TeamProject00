package main.list;

public class MyArrayList implements List{

    private Object[] arr = new Object[100];
    private Integer size = 0;

    @Override
    public Object get(Integer i) {
        if (indexOutOfRange(i)){
            throw new IndexOutOfBoundsException();
        }
        else{
            return arr[i];
        }
    }

    @Override
    public Object set(Integer i, Object e) {
        if (indexOutOfRange(i)){
            throw new IndexOutOfBoundsException();
        }
        else{
            Object old = arr[i];
            arr[i] = e;
            return old;
        }
    }

    @Override
    public void add(Integer i, Object e) {
        if(i<0 || i>this.size){
            throw new IndexOutOfBoundsException();
        }
        else{
            for (int j=size-1; j>=i; j--){
                arr[j+1] = arr[j];
            }
            arr[i] = e;
            size++;
        }
    }

    @Override
    public Object remove(Integer i) {
        if (indexOutOfRange(i)){
            throw new IndexOutOfBoundsException();
        }
        else {
            Object old = arr[i];
            for (int j=i; j<size-1; j++){
                arr[j] = arr[j+1];
            }
            arr[size-1] = null;
            size--;
            return old;
        }
    }

    @Override
    public Integer size(){
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean indexOutOfRange(Integer i) {
        return i < 0 || i > this.size - 1;
    }
}
