import java.util.ArrayList;
import java.util.List;

import static com.google.common.math.IntMath.isPrime;

public class PrimeChekerThread {

    PrimeChekerThread(List<Integer> arr, int cores) {
        this.arr = arr;
        this.cores = cores;
        this.run();

    }

    List<Integer> arr;
    private int cores;
    MyThread[] myThreads;
    private long time;
    private boolean res = false;

    boolean getRes() {
        return res;
    }

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
            for (Integer b : a) {
                res |= !isPrime(b);
                if (res) return;
            }

        }
    }

    private void run() {
        long start = System.currentTimeMillis();
        int tmp = arr.size() / cores;
        this.myThreads = new MyThread[cores];
        for (int i = 0; i < cores; i++) {
            myThreads[i] = new MyThread(arr.subList(i * tmp, (i + 1) * tmp));
            myThreads[i].start();
        }
        for (int i = 0; i < cores; i++) {
            try {
                myThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }
}
