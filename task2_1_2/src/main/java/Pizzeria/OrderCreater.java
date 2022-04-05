package Pizzeria;

public class OrderCreater extends Thread {
    private PizzaQueue a;
    private Integer WT;
    OrderCreater(PizzaQueue a,Integer WT){
        this.a=a;
        this.WT=WT;
    }
    @Override
    public void run(){
        Long current = System.currentTimeMillis()/1000;
        while(System.currentTimeMillis()/1000-current<this.WT){
            a.lock();
            a.push("Mozzarala");
            a.push("HoHo");
            a.push("4 cheese");
            a.unlock();
            System.out.println("3 pizzas added to queue");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}