package Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    static Double count(String args) {
        Stack<Double> calc = new Stack<>();
        String[] elements = args.split(" ");
        for (int i = elements.length - 1; i >= 0; i--) {
            try {
                calc.push(Double.parseDouble(elements[i]));
            } catch (NumberFormatException e) {
                if (elements[i].equals("+")) {
                    if (calc.size() < 2)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(calc.pop() + calc.pop());
                } else if (elements[i].equals("-")) {
                    if (calc.size() < 2)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(calc.pop() - calc.pop());
                } else if (elements[i].equals("*")) {
                    if (calc.size() < 2)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(calc.pop() * calc.pop());
                } else if (elements[i].equals("/")) {
                    if (calc.size() < 2)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(calc.pop() / calc.pop());
                } else if (elements[i].equals("pow")) {
                    if (calc.size() < 2)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(Math.pow(calc.pop(), calc.pop()));
                } else if (elements[i].equals("sin")) {
                    if (calc.size() < 1)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(Math.sin(calc.pop()));
                } else if (elements[i].equals("cos")) {
                    if (calc.size() < 1)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(Math.cos(calc.pop()));
                } else if (elements[i].equals("log")) {
                    if (calc.size() < 1)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(Math.log(calc.pop()));
                } else if (elements[i].equals("sqrt")) {
                    if (calc.size() < 1)
                        throw new InputMismatchException("invalid syntax of the expression");
                    calc.push(Math.sqrt(calc.pop()));
                } else {
                    throw new UnsupportedOperationException(elements[i] + "- is an invalid operation");
                }
            }
        }
        Double res = calc.pop();
        if (calc.isEmpty())
            return res;
        else {
            throw new InputMismatchException("invalid syntax of the expression");
        }

    }

    public double Calctst(String args) {
        return count(args);
    }

    public void Calc() {
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
                    System.out.println(Calculator.count(clc));
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

