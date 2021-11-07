import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class test {
    @Test
    void basicFuncTest(){
        String a="sin 0";
        Calculator c= new Calculator();
        assert(c.Calctst(a)==0);
        a="cos 0";
        assert(c.Calctst(a)==1);
        a="+ 1 1";
        assert(c.Calctst(a)==2);
        a="- 1 1";
        assert(c.Calctst(a)==0);
        a="/ 1 1";
        assert(c.Calctst(a)==1);
        a="* 1 1";
        assert(c.Calctst(a)==1);
        a="log 1";
        assert(c.Calctst(a)==0);
        a="pow 2 3";
        assert(c.Calctst(a)==8);
        a="sqrt 4";
        assert(c.Calctst(a)==2);
    }
    @Test
    void invalidInputsTest(){
        Calculator c= new Calculator();
        UnsupportedOperationException e1 = assertThrows(UnsupportedOperationException.class, () ->
        {c.Calctst("bulbul 1");});
        assertEquals(e1.getMessage(),"bulbul- is an invalid operation");
        InputMismatchException e2 = assertThrows(InputMismatchException.class, () ->
        {c.Calctst("+ 1 1 + 1 1");});
        assertEquals(e2.getMessage(),"invalid syntax of the expression");
    }
}
