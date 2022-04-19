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
    public Pizzeria(String Config) {
        bakers=new ArrayList<>();
        cureers=new ArrayList<>();
        pizzaQueue=new PizzaQueue();

        JsonReader js=new JsonReader();
        try {
            conf=js.read(Config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        storage=new Storage(conf.getStSize());
       for (int i=0;i<conf.getBakerConf().size();i++){
           bakers.add(new Baker(conf.getBakerConf().get(i),storage,pizzaQueue,conf.getWT()));
       }
       for(int i=0;i<conf.getCureerConf().size();i++)
       {cureers.add(new Cureer(conf.getCureerConf().get(i),storage,pizzaQueue,conf.getWT()));}
        orderCreater = new OrderCreater(pizzaQueue,conf.getStSize());
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
    }
}

