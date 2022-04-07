package Workers.Baker;

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
            String a = "";
            synchronized (
                    pizzaQueue
            ) {
                if (!pizzaQueue.isEmpty()) {
                    a = pizzaQueue.poll();
                    cooking();
                }
            }
            if (!a.equals("")) {
                boolean f = true;
                while (f) {
                    synchronized (storage) {
                        f= storage.isFull();
                        if (!f) {
                            storage.push(a);
                            System.out.println("Pizza " + a + " baked and placed in storage by: " + this.getName());
                        }
                        else{
                            try {
                                System.out.println("Pizza " + a + " baked but storage is full " +this.getName() + " waits to place it");
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        }
    }
}
