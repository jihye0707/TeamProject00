package main.queue;

import main.stack.ArrayStack;

public class StackQueue implements Queue {

    private ArrayStack inStack = new ArrayStack();
    private ArrayStack outStack = new ArrayStack();

    @Override
    public int size() {
        return (inStack.size() + outStack.size());
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public char front() {
        if (isEmpty())
            throw new RuntimeException("EmptyQueueException");

        if (outStack.isEmpty()) {
            while(!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
        return outStack.top();
    }


    @Override
    public void enqueue(char o) {
        if (size() >= 100) {
            throw new RuntimeException("FullQueueException");
        }
        inStack.push(o);
    }

    @Override
    public char dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("EmptyQueueException");
        }

        if (outStack.isEmpty()) {
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

}
