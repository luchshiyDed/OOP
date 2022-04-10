import Pizzeria.PizzaQueue;
import Pizzeria.Storage;
import Workers.Baker.Baker;
import Workers.Baker.BakerConf;
import Workers.Cureer.Cureer;
import Workers.Cureer.CureerConf;
import org.junit.jupiter.api.Test;
public class Tests {
    @Test
    public void bakerTest() throws InterruptedException {
        Integer WT=1;
        PizzaQueue pq=new PizzaQueue();
        Storage storage=new Storage(3);
        BakerConf bc=new BakerConf(1000,"a");
        Baker b =new Baker(bc,storage,pq,WT);
        Thread a = new Thread(b);
        pq.push("Pizza");
        a.start();
        a.join();
        synchronized (pq)
        {assert(pq.isEmpty());}
        synchronized (storage)
        {assert(!storage.isEmpty());}
        String str=storage.poll();
        assert(str.equals("Pizza #0"));
    }
    @Test
    public void cureerTest() throws InterruptedException {
        Integer WT=1;
        Storage storage=new Storage(3);
        PizzaQueue pq=new PizzaQueue();
        CureerConf bc=new CureerConf(1000,"a");
        Cureer b =new Cureer(bc,storage,pq,WT);
        Thread a = new Thread(b);
        storage.push("Pizza");
        a.start();
        a.join();
        synchronized (storage)
        {assert(storage.isEmpty());}
    }

}
