package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    static void cheker(Stack a, Integer b,String s) {
        if (a.size() < b) throw new InputMismatchException("invalid syntax of the expression "+s+" needs at least "+b.toString()+" arguments");
    }

    public static Double calculate(String args) {
        Stack<Double> calc = new Stack<>();
        String[] elements = args.split(" ");
        for (int i = elements.length - 1; i >= 0; i--) {
            try {
                calc.push(Double.parseDouble(elements[i]));
            } catch (NumberFormatException e) {
                switch (elements[i]) {
                    case ("+") -> {
                        cheker(calc, 2,elements[i]);
                        calc.push(calc.pop() + calc.pop());
                    }
                    case ("-") -> {
                        cheker(calc, 2,elements[i]);
                        calc.push(calc.pop() - calc.pop());
                    }
                    case ("*") -> {
                        cheker(calc, 2,elements[i]);
                        calc.push(calc.pop() * calc.pop());
                    }
                    case ("/") -> {
                        cheker(calc, 2,elements[i]);
                        calc.push(calc.pop() / calc.pop());
                    }
                    case ("pow") -> {
                        cheker(calc, 2,elements[i]);
                        calc.push(Math.pow(calc.pop(), calc.pop()));
                    }
                    case ("sin") -> {
                        cheker(calc, 1,elements[i]);
                        calc.push(Math.sin(calc.pop()));
                    }
                    case ("cos") -> {
                        cheker(calc, 1,elements[i]);
                        calc.push(Math.cos(calc.pop()));
                    }
                    case ("log") -> {
                        cheker(calc, 1,elements[i]);
                        calc.push(Math.log(calc.pop()));
                    }
                    case ("sqrt") -> {
                        cheker(calc, 1,elements[i]);
                        calc.push(Math.sqrt(calc.pop()));
                    }
                    default -> throw new UnsupportedOperationException(elements[i] + "- is an invalid operation");
                }
            }
        }
        if (calc.isEmpty())
            throw new InputMismatchException("invalid syntax of the expression");
        Double res = calc.pop();
        if (calc.isEmpty())
            return res;
        else {
            throw new InputMismatchException("invalid syntax of the expression too much arguments");
        }

    }


}

