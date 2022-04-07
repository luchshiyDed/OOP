import Pizzeria.Pizzeria;

public class Main {
    public static void main(String[] args){
        Pizzeria pizzeria=new Pizzeria("src/main/resources/config2.json");
        pizzeria.start();
    }
}
