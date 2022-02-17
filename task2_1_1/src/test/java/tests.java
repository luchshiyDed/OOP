import org.junit.jupiter.api.Test;

import java.util.List;

public class tests {
    @Test
    void funcCurrectanswerTest(){
        List<Integer> arr=List.of(new Integer[]{2, 3, 5, 7, 11});
        PrimeChekerThread a=new PrimeChekerThread(arr,1);
        PrimeChekerFirst b=new PrimeChekerFirst(arr);
        ParallelStream c=new ParallelStream(arr);
        assert(a.getRes()==false);
        assert(a.getRes()==b.getRes());
        assert(c.getRes()==b.getRes());
        List<Integer> arr1=List.of(new Integer[]{2, 3, 5, 7, 11,1});

        PrimeChekerThread a1=new PrimeChekerThread(arr1,1);
        PrimeChekerFirst b1=new PrimeChekerFirst(arr1);
        ParallelStream c1=new ParallelStream(arr1);
        assert(a1.getRes()==b1.getRes());
        assert(c1.getRes()==b1.getRes());
        assert(a1.getRes()==true);

    }
}
