import java.util.ArrayList;

import static com.google.common.math.IntMath.isPrime;

public class PrimeChekerFirst extends Thread{

    private ArrayList<Integer> arr;
    private long time;
    private boolean res=true;
    PrimeChekerFirst(ArrayList<Integer> arr) {
        this.arr = arr;
    }
    long getTime(){return time;}
    boolean getRes(){return res;}
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (Integer a : arr) {
            if (!isPrime(a.intValue())) {
                long finish = System.currentTimeMillis();
                time = finish - start;
                res=false;
            }
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }
}

