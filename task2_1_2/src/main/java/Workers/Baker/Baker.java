package Workers.Baker;

import Pizzeria.Order;
import Pizzeria.PizzaQueue;
import Pizzeria.Storage;
import Workers.PizzeriaWorker;


public class Baker extends PizzeriaWorker {
    private Storage storage;
    private PizzaQueue pizzaQueue;

    private void cooking() {
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Baker(BakerConf conf, Storage storage, PizzaQueue pizzaQueue, Integer WT) {
        this.setWorkTime(WT);
        this.setTaskTime(conf.getTT());
        this.setName(conf.getName());
        this.storage = storage;
        this.pizzaQueue = pizzaQueue;
    }

    @Override
    protected void workProcess() {
        Long current = System.currentTimeMillis() / 1000;
        while (System.currentTimeMillis() / 1000 - current < this.getWorkTime() || !pizzaQueue.isEmpty()) {
            Order a = null;
            Boolean flg = false;
            synchronized (
                    pizzaQueue
            ) {
                if (!pizzaQueue.isEmpty()) {
                    a = pizzaQueue.poll();
                    cooking();
                    flg = true;
                }
            }
            if (flg) {
                boolean f = true;
                while (f) {
                    synchronized (storage) {
                        f = storage.isFull();
                        if (!f) {
                            storage.push(a);
                            System.out.println("Pizza " + a.getOrderWithName() + " baked and placed in storage by: " + this.getName());
                        } else {
                            System.out.println("Pizza " + a.getOrderWithName() + " baked but storage is full " + this.getName() + " waits to place it");
                        }
                    }
                    if (f) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
