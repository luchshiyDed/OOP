import java.util.List;
import java.util.stream.Stream;

import static com.google.common.math.IntMath.isPrime;

public class ParallelStream {
    private boolean res = false;
    private List<Integer> arr;
    private long time;
    ParallelStream(List<Integer> arr) {
        this.arr = arr;
        this.run();
    }
    long getTime(){return time;}
    boolean getRes(){return res;}
    private void run() {
        long start = System.currentTimeMillis();
        if(arr.parallelStream().filter(a->!isPrime(a)).count()>0){
            res=true;
        }
        long finish = System.currentTimeMillis();
        time = finish - start;
    }
}
