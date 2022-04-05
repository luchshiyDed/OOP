package Workers.Cureer;

import Pizzeria.Storage;
import Workers.PizzeriaWorker;

public class Cureer extends PizzeriaWorker {

    private Storage storage;
    private void working() {
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Cureer(CureerConf conf, Storage storage, Integer WT){
        this.setWorkTime(WT);
        this.setTaskTime(conf.getTT());
        this.setName(conf.getName());
        this.storage=storage;
    }

    @Override
    public void workProcess() {
        Long current = System.currentTimeMillis()/1000;
        while(System.currentTimeMillis()/1000-current<this.getWorkTime() || !storage.isEmpty()){
            if(!storage.isEmpty()){
                storage.lock();
                String a=storage.poll();
                storage.unlock();
                working();
                System.out.println("Pizza " + a+ " was delivered by: " + this.getName());
            }
        }
    }
}
