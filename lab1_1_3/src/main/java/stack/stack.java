package stack;
import java.util.*;
public class stack<T> {

    int len=0;
    int head=-1;
    public T[] arr = ((T[]) new Object[0]);


    void extArr(int ln){
        arr=Arrays.copyOf(arr,ln);
    };


    public T pop() throws Exception {
    if(head<0){
        Exception e;
        throw e= new IndexOutOfBoundsException("Stack is empty");
    }
    head--;
    return (T) arr[head+1];
    };

    public void push(T v){
        head++;
        if(head==len){extArr(len=2*len+1);};
        int a = head;
        arr[a]=v;
    };
    public void pushStack(T[] ar){
        int n=ar.length;
        if(head+n>=len){extArr(len=2*len+n);};
        for(int i=0;i<n;i++){
            push(ar[i]);
        }
    };
    public stack popStack(int n) throws Exception {
        if(head<0){
            Exception e;
            throw e= new IndexOutOfBoundsException("Stack is empty");
        }
        int a=head-n;
        if (a<0)a=-1;
        stack<T> ret=new stack();
        ret.arr=Arrays.copyOfRange(arr,a+1,head+1);
        ret.head=n-1;
        ret.len=n;
        head=a;
        return ret;
    };
    public int count(){return head+1;};

}
