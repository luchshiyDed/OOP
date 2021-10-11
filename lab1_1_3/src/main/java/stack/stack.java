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
        arr[head] = v;
    }


    public void pushStack(stack ar) throws Exception {
        int n = ar.count();
        if (head + n >= len) {
            extArr(len = 2 * len + n);
        }
        T[] buf=(T[]) new Object[n];
        for(int i=0;i<n;i++){
            buf[i]=(T) ar.pop();
        }
        for (int i = 0; i < n; i++) {
            this.push(buf[n-i-1]);
        }
    }


    public stack popStack(int n) throws Exception {
        if (head < 0) {
            Exception e;
            throw e = new IndexOutOfBoundsException("Stack is empty");
        }
        if(head-n<0){
            Exception e;
            throw e = new IndexOutOfBoundsException("Not enough elements in stack");
        }
        int a = head - n;
        stack<T> ret = new stack();
        for(int i=0;i<n;i++)
        {ret.push(this.arr[a+i+1]);this.pop();}
        return ret;
    }


    public int count() {
        return head + 1;
    }


}
