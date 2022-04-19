package Pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage {
    private static ArrayBlockingQueue<Order> itemsInStorage;
    public Storage(int cap){
        itemsInStorage=new ArrayBlockingQueue<>(cap);
    }
    public boolean isEmpty(){
        return itemsInStorage.isEmpty();
    }
    public Order poll(){
            return itemsInStorage.poll();
    }
    public void push(Order val){
        itemsInStorage.add(val);
    }
    public boolean isFull(){
        return itemsInStorage.remainingCapacity()==0;
    }
}
