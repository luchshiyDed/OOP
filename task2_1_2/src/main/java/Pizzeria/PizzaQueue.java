package Pizzeria;

import java.util.concurrent.LinkedBlockingQueue;

public class PizzaQueue {
    private static LinkedBlockingQueue<String> waitingOrders;
    private Integer orderNumber=0;
    PizzaQueue(){
        waitingOrders=new LinkedBlockingQueue<String>();
    }
    public boolean isEmpty(){
        return waitingOrders.isEmpty();
    }
    public String poll(){
        return waitingOrders.poll();
    }
    public void push(String val){
       waitingOrders.add(val + " #" + orderNumber);
       orderNumber++;
    }
}
