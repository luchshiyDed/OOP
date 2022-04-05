import Pizzeria.Pizzeria;

public class Main {
    public static void main(String[] args){
        Pizzeria pizzeria=new Pizzeria("src/Bakers.json", "src/Cureers.json",20);
        pizzeria.start();
    }
}
