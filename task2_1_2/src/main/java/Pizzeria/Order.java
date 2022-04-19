package Pizzeria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    Integer Num;
    String Name;
    public String getOrderWithName(){
        return Name+" "+Num;
    }
}
