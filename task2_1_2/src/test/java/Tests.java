import JsonReader.JsonReader;
import Pizzeria.Order;
import Pizzeria.PizzaQueue;
import Pizzeria.PizzeriaConf;
import Pizzeria.Storage;
import Workers.Baker.Baker;
import Workers.Cureer.Cureer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Tests {
    @Test
    public void bakerTest() throws InterruptedException, IOException {
        Integer WT=1;
        PizzaQueue pq=new PizzaQueue();
        Storage storage=new Storage(3);
        JsonReader js=new JsonReader();
        PizzeriaConf PC=js.read("src/test/resources/tstconf.json");
        Baker b =new Baker(PC.getBakerConf().get(0),storage,pq,WT);
        Thread a = new Thread(b);
        pq.push("Pizza");
        a.start();
        a.join();
        synchronized (pq)
        {assert(pq.isEmpty());}
        synchronized (storage)
        {assert(!storage.isEmpty());}
        Order str=storage.poll();
        Order res=new Order(0,"Pizza");
        assert(str.equals(res));
    }
    @Test
    public void cureerTest() throws InterruptedException, IOException {
        Integer WT=1;
        Storage storage=new Storage(3);
        PizzaQueue pq=new PizzaQueue();
        JsonReader js=new JsonReader();
        PizzeriaConf PC=js.read("src/test/resources/tst2conf.json");
        Cureer b =new Cureer(PC.getCureerConf().get(0),storage,pq,WT);
        Thread a = new Thread(b);
        storage.push(new Order(0,"Pizza"));
        a.start();
        a.join();
        synchronized (storage)
        {assert(storage.isEmpty());}
    }

}
