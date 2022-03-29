
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) {

        List<Integer> arr;
        int m=10;
        ArrayList<Long> res=new ArrayList<Long>();
        Generator g=new Generator(1000000);
        arr=g.getList();
        PrimeChekerFirst a = new PrimeChekerFirst(arr);
        PrimeChekerThread[] b = new PrimeChekerThread[m];
        for(int i=0;i<m;i++)
        {b[i]=new PrimeChekerThread(arr,i+1);
         res.add(b[i].getTime());
        }
        long min=res.stream().min(Long::compareTo).get();
        ParallelStream c=new ParallelStream(arr);
        Diag gr1=new Diag(new ArrayList<Long>(List.of(new Long[]{a.getTime(), min, c.getTime()})),new ArrayList<>(List.of(new String[]{"StepByStep","Threads","ParallelStream"})));
        gr1.setVisible(true);
        Diag gr = new Diag (res,new ArrayList<>(List.of(new String[]{"Threads"})) );
        gr.setVisible(true);
        System.out.println(a.getTime());
    }
}
