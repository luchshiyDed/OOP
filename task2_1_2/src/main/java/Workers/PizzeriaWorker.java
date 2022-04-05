package Workers;

import lombok.Data;

import java.util.Date;

@Data
public abstract class PizzeriaWorker implements Runnable{
    private Integer workTime;
    private int taskTime;
    private String name;

     protected abstract void workProcess();

    private void StartWorkMessage(){
        Date current = new Date();
        System.out.println(this.getClass().toString() +" " + this.getName()+" "+"started at:" + current  );
    }

    protected  void msg(String a){
        Date current = new Date();
        System.out.println(this.getClass().toString() +" " + this.getName()+" "+"time:" + current + " "+ a);
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
