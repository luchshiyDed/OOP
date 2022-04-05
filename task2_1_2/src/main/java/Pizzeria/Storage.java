package Pizzeria;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
    private static Lock storageLock;
    private static ArrayBlockingQueue<String> itemsInStorage;
    Storage(int cap){
        itemsInStorage=new ArrayBlockingQueue<>(cap);
        storageLock=new ReentrantLock();
    }
    public void lock(){
        storageLock.lock();
    }
    public void unlock(){
        storageLock.unlock();
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
}
