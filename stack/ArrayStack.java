package main.stack;

import java.util.EmptyStackException;

public class ArrayStack implements Stack {

    private char[] arr = new char[100];
    private int size = 0;
    private int top = -1;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public char top() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return arr[top];
    }

    @Override
    public char push(char o) {
        if (size >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        arr[++top] = o;
        size++;
        return o;
    }

    @Override
    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        return arr[top--];
    }

    public void revPrint() {
        for (int i = top; i >=0; i--) {
            char c = arr[i];

            if (c == '(') {
                System.out.print(')');
            }
            else if(c == ')'){
                System.out.print('(');
            }
            else {
                System.out.print(c);
            }
        }
        System.out.println();
    }

}
