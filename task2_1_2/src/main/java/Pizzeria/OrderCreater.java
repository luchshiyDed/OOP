package Pizzeria;

public class OrderCreater extends Thread {
    private PizzaQueue a;
    private int WT;
    OrderCreater(PizzaQueue a,Integer WT){
        this.a=a;
        this.WT=WT;
    }
    @Override
    public void run(){
        Long current = System.currentTimeMillis()/1000;
        while(System.currentTimeMillis()/1000-current<this.WT){
           synchronized (a) {
                a.push("Mozzarala");
                a.push("HoHo");
                a.push("4 cheese");
            }
            System.out.println("3 pizzas added to queue");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
