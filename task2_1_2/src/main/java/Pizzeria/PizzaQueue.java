package Pizzeria;

import java.util.concurrent.LinkedBlockingQueue;

public class PizzaQueue {
    private static LinkedBlockingQueue<Order> waitingOrders;
    private Integer orderNumber=0;
    public PizzaQueue(){
        waitingOrders=new LinkedBlockingQueue<Order>();
    }
    public boolean isEmpty(){
        return waitingOrders.isEmpty();
    }
    public Order poll(){
        return waitingOrders.poll();
    }
    public void push(String val){
       waitingOrders.add(new Order(orderNumber,val));
       orderNumber++;
    }
}
