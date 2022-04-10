package Pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage {
    private static ArrayBlockingQueue<String> itemsInStorage;
    public Storage(int cap){
        itemsInStorage=new ArrayBlockingQueue<>(cap);
    }
    public boolean isEmpty(){
        return itemsInStorage.isEmpty();
    }
    public String poll(){
            return itemsInStorage.poll();
    }
    public void push(String val){
        itemsInStorage.add(val);
    }
    public boolean isFull(){
        return itemsInStorage.remainingCapacity()==0;
    }
}
