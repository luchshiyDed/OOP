package Workers.Cureer;

import Pizzeria.PizzaQueue;
import Pizzeria.Storage;
import Workers.PizzeriaWorker;

public class Cureer extends PizzeriaWorker {

    private Storage storage;
    private PizzaQueue pizzaQueue;
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
    }

    @Override
    public void workProcess() {
        Long current = System.currentTimeMillis() / 1000;
        while (System.currentTimeMillis() / 1000 - current < this.getWorkTime() || !pizzaQueue.isEmpty()) {
            String a ="";
            synchronized (storage) {
                if (!storage.isEmpty()) {
                     a = storage.poll();

                }
                if(!a.equals("")){
                    working();
                    System.out.println("Pizza " + a + " was delivered by: " + this.getName());
                }
            }
        }
    }
}
