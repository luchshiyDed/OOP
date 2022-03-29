package Workers.Cureer;

import Workers.PizzeriaWorker;

public class Cureer extends PizzeriaWorker {

    private void working() {
        try {
            Thread.sleep(this.getTaskTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Cureer(String name, int WT, int TT){
        this.setNam(name);
        this.setWorkTime(WT);
        this.setTaskTime(TT);
    }

    @Override
    public void workProcess() {
        while (this.getWorkTime() > 0) {

        }
    }
}
