package Workers.Baker;

import Workers.PizzeriaWorker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Baker extends PizzeriaWorker {

    private void cooking(){
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public Baker(String name, int WT, int TT){
        this.setNam(name);
        this.setWorkTime(WT);
        this.setTaskTime(TT);
    }

    @Override
    public void workProcess() {

        while(this.getWorkTime()>0)
        {
        }

    }


}
