import java.util.ArrayList;
import java.util.List;

import static com.google.common.math.IntMath.isPrime;

public class PrimeChekerThread extends Thread{
    PrimeChekerThread(ArrayList<Integer> arr, int cores) {
        this.arr = arr;
        this.cores = cores;
    }
    ArrayList<Integer> arr;
    private int cores;
    MyThread[] myThreads = new MyThread[cores];
    private long time;
    private boolean res = true;

    long getTime() {
        return time;
    }

    public class MyThread extends Thread {
        MyThread(List<Integer> a) {
            this.a = a;
        }
        private List<Integer> a;

        @Override
        public void run() {
            for (Integer b : a)
                res &= isPrime(b);

        }
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int tmp=arr.size()/cores;
        for (int i = 0; i < cores; i++){
            myThreads[i]=new MyThread(arr.subList(i*tmp,(i+1)*tmp));
            myThreads[i].start();
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }
}
