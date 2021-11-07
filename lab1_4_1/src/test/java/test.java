import Calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
        String a="bulbul";
        Calculator c= new Calculator();
    }
}
