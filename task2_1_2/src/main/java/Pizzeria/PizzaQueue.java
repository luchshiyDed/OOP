package Pizzeria;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PizzaQueue {
    private static Lock queueLock;
    private static LinkedBlockingQueue<String> waitingOrders;

    PizzaQueue(){
        waitingOrders=new LinkedBlockingQueue<String>();
        queueLock=new ReentrantLock();
    }
    public void lock(){
        queueLock.lock();
    }
    public void unlock() {
        queueLock.unlock();
    }
    public boolean isEmpty(){
        return waitingOrders.isEmpty();
    }
    public String poll(){
        return waitingOrders.poll();
    }
    public void push(String val){
       waitingOrders.add(val);
    }
}
