package stack;

import java.util.*;

public class stack<T> {
    @SuppressWarnings("unchecked")
    private int len = 0;
    private int head = -1;
    private T[] arr = ((T[]) new Object[0]);


    void extArr(int ln) {
        arr = Arrays.copyOf(arr, ln);
    }



    public T pop() throws Exception {
        if (head < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        head--;
        return (T) arr[head + 1];
    }


    public void push(T v) {
        head++;
        if (head == len) {
            extArr(len = 2 * len + 1);
        }
        ;
        int a = head;
        arr[a] = v;
    }


    public void pushStack(stack ar) throws Exception {
        int n = ar.count();
        if (head + n >= len) {
            extArr(len = 2 * len + n);
        }
        for (int i = 0; i < n; i++) {
            this.push((T) ar.pop());
        }
    }


    public stack popStack(int n) throws Exception {
        if (head < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        int a = head - n;
        if (a < 0) a = -1;
        stack<T> ret = new stack();
        for(int i=0;i<n;i++)
        {ret.push(this.pop());}
        head = a;
        return ret;
    }


    public int count() {
        return head + 1;
    }


}
