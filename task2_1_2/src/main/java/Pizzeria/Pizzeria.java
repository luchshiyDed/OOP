package Pizzeria;

import com.google.gson.Gson;
import Workers.Baker.Baker;
import Workers.Cureer.Cureer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Pizzeria implements Runnable {
    private ArrayList<Baker> bakers;
    private ArrayList<Cureer> cureers;
    Pizzeria(String Bakers, String Cureers) {

        workersInfo[] arr=gson.fromJson(r, workersInfo[].class);
        workersInfo[] arr1=gson.fromJson(r1, workersInfo[].class);


    }

    @Override
    public void run() {

        while(true){
            for(int i=0;i<bakers.size()/2;i++){
                    bakers.get(i).start();
            }
            for(int i=0;i<cureers.size()/2;i++){
                cureers.get(i).start();
            }
            }
        }
    }

