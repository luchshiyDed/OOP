package Workers;

import java.util.Date;
import java.util.concurrent.locks.Lock;

public abstract class PizzeriaWorker extends Thread {
    private Integer workTime;
    private int taskTime;
    private String name;
    /**
     *  logic of working, exp: baker waits for a customer, bakes smth, gives it to a customer.
     */
   protected abstract void workProcess();

    /**
     *
     * @return true - if Worker has no work to do
     */

    public String getNam(){
        return this.name;
    }
    public int getWorkTime(){
        return workTime;
    }
    public int getTaskTime(){
        return taskTime;
    }


    public void setNam(String name){this.name=name;}
    public void setWorkTime(int WT){
        this.workTime=WT;
    }
    public void setTaskTime(int TT){this.taskTime=TT;}

    private void StartWorkMessage(){
        Date current = new Date();
        System.out.println(this.getClass().toString() +" " + this.getName()+" "+"started at:" + current  );
    }

    protected  void msg(String a){
        Date current = new Date();
        System.out.println(this.getClass().toString() +" " + this.getName()+" "+"time:" + current + " "+ a);
    }
    protected void rest(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    private void EndWorkMessage(){
        Date current = new Date();
        System.out.println(this.getClass().toString() +" " + this.getName()+" "+"ended at:" + current);
    }
    @Override
    public void run() {
        StartWorkMessage();
        workProcess();
        EndWorkMessage();
    }
}
