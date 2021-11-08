import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class test {
    @Test
    void basicFuncTest(){
        Calculator c= new Calculator();
        assert(c.calculate("sin 0")==0);
        assert(c.calculate("cos 0")==1);
        assert(c.calculate("+ 1 1")==2);
        assert(c.calculate("- 1 1")==0);
        assert(c.calculate("/ 1 1")==1);
        assert(c.calculate("* 1 1")==1);
        assert(c.calculate("log 1")==0);
        assert(c.calculate("pow 2 3")==8);
        assert(c.calculate("sqrt 4")==2);
    }
    @Test
    void invalidInputsTest(){
        Calculator c= new Calculator();
        UnsupportedOperationException e1 = assertThrows(UnsupportedOperationException.class, () ->
        {c.calculate("bulbul 1");});
        assertEquals(e1.getMessage(),"bulbul- is an invalid operation");
        InputMismatchException e2 = assertThrows(InputMismatchException.class, () ->
        {c.calculate("+ 1 1 + 1 1");});
        assertEquals(e2.getMessage(),"invalid syntax of the expression too much arguments");
    }
}
