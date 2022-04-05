package Workers.Baker;

import Pizzeria.PizzaQueue;
import Pizzeria.Storage;
import Workers.PizzeriaWorker;


public class Baker extends PizzeriaWorker {
    private Storage storage;
    private PizzaQueue pizzaQueue;
    private void cooking(){
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Baker(BakerConf conf,Storage storage,PizzaQueue pizzaQueue,Integer WT){
        this.setWorkTime(WT);
        this.setTaskTime(conf.getTT());
        this.setName(conf.getName());
        this.storage=storage;
        this.pizzaQueue=pizzaQueue;
    }

    @Override
    protected void workProcess() {
        Long current = System.currentTimeMillis()/1000;
        while(System.currentTimeMillis()/1000-current<this.getWorkTime()|| !pizzaQueue.isEmpty()){
            if(!pizzaQueue.isEmpty()){
                pizzaQueue.lock();
                String a=pizzaQueue.poll();
                pizzaQueue.unlock();
                cooking();
                storage.lock();
                storage.push(a);
                storage.unlock();
                System.out.println("Pizza " + a + " baked and placed in storage by: " + this.getName());
            }
        }
    }
}
