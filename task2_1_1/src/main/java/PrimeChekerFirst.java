import java.util.List;

import static com.google.common.math.IntMath.isPrime;

public class PrimeChekerFirst{
    private List<Integer> arr;
    private long time;
    private boolean res=false;
    PrimeChekerFirst(List<Integer> arr) {
        this.arr = arr;
        this.run();
    }
    long getTime(){return time;}
    boolean getRes(){return res;}
    private void run() {
        long start = System.currentTimeMillis();
        for (Integer a : arr) {
            if (!isPrime(a.intValue())) {
                res=true;
            }
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }
}

