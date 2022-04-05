package Pizzeria;

import JsonReader.JsonReader;
import Workers.Baker.Baker;
import Workers.Cureer.Cureer;

import java.io.IOException;
import java.util.ArrayList;

public class Pizzeria extends Thread {
    private ArrayList<Baker> bakers;
    private ArrayList<Cureer> cureers;
    private PizzeriaConf conf;
    private Storage storage;
    private PizzaQueue pizzaQueue;
    private  OrderCreater orderCreater;
    public Pizzeria(String Bakers, String Cureers, Integer WT) {
        bakers=new ArrayList<>();
        cureers=new ArrayList<>();
        conf=new PizzeriaConf();
        pizzaQueue=new PizzaQueue();
        storage=new Storage(40);
        JsonReader js=new JsonReader();
        try {
            conf=js.read(Bakers,Cureers);
        } catch (IOException e) {
            e.printStackTrace();
        }
       for (int i=0;i<conf.BakerConf.size();i++){
           bakers.add(new Baker(conf.BakerConf.get(i),storage,pizzaQueue,WT));
       }
       for(int i=0;i<conf.CureerConf.size();i++)
       {cureers.add(new Cureer(conf.CureerConf.get(i),storage,WT));}
        orderCreater = new OrderCreater(pizzaQueue,WT);
    }

    @Override
    public void run() {
        for(int i=0;i<bakers.size();i++){
            Thread a = new Thread(bakers.get(i));
            a.start();
        }
        for(int i=0;i<cureers.size();i++){
            Thread a = new Thread(cureers.get(i));
            a.start();
        }
        orderCreater.start();
        try {
            orderCreater.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

