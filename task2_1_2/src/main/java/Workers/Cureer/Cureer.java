package Workers.Cureer;

import Pizzeria.Order;
import Pizzeria.PizzaQueue;
import Pizzeria.Storage;
import Workers.PizzeriaWorker;
import java.util.concurrent.ArrayBlockingQueue;

public class Cureer extends PizzeriaWorker {

    private Storage storage;
    private PizzaQueue pizzaQueue;
    private ArrayBlockingQueue<Order> backpack;
    private void working() {
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Cureer(CureerConf conf, Storage storage,PizzaQueue pizzaQueue, Integer WT) {
        this.setWorkTime(WT);
        this.setTaskTime(conf.getTT());
        this.setName(conf.getName());
        this.storage = storage;
        this.pizzaQueue=pizzaQueue;
        backpack=new ArrayBlockingQueue<Order>(conf.getBP());
    }

    @Override
    public void workProcess() {
        Long current = System.currentTimeMillis() / 1000;
        while (System.currentTimeMillis() / 1000 - current < this.getWorkTime() || !pizzaQueue.isEmpty()) {
            synchronized (storage) {
                while (!storage.isEmpty() & backpack.remainingCapacity()>0) {
                     backpack.add(storage.poll());
                }

            }
           while(!backpack.isEmpty()){
                working();
                Order a =backpack.poll();
                System.out.println("Pizza " + a.getOrderWithName() + " was delivered by: " + this.getName());
            }
        }
    }
}
