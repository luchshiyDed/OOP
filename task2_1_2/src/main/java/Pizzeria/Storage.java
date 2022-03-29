package Pizzeria;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;

public class Storage {
    private Lock storageLock;
    private ArrayBlockingQueue<String> itemsInStorage;
    Storage(int cap){
        itemsInStorage=new ArrayBlockingQueue<>(cap);
    }
    public void lock(){
        storageLock.lock();
    }
    public void unlock(){
        storageLock.unlock();
    }
    public String pop(){
        if(!itemsInStorage.isEmpty())
            return itemsInStorage.poll();
        else return "";
    }
    public void push(String val){
        itemsInStorage.add(val);
    }
}
