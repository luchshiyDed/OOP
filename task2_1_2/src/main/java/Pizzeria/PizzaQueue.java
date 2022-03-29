package Pizzeria;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;

public class PizzaQueue {
    private Lock queueLock;
    private LinkedBlockingQueue<String> waitingOrders;

    PizzaQueue(){
        waitingOrders=new LinkedBlockingQueue<String>();
    }
    public void lock(){
        queueLock.lock();
    }
    public void unlock(){
        queueLock.unlock();
    }
    public String pop(){
        if(!waitingOrders.isEmpty())
            return waitingOrders.poll();
        else return "";
    }
    public void push(String val){
       waitingOrders.add(val);
    }
}
