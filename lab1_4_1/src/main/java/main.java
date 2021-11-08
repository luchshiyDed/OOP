import Calculator.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello this is prefix calculator, you have some functions here. If you want to end, write:end");
        System.out.println("If you want to see available functions write: func");
        String clc;
        clc = input.nextLine();
        while (!clc.equals("end")) {
            try {
                if (clc.equals("func")) {
                    System.out.println("+,-,*,/,sin,cos,pow,log,sqrt");
                } else
                    System.out.println(Calculator.calculate(clc));
            } catch (UnsupportedOperationException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());
            }
            clc = input.nextLine();
        }
        input.close();

    }
}