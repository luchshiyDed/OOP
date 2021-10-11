import org.junit.jupiter.api.Test;
import stack.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class tests {
    @Test
    void empty_Stack_test() throws Exception{
        stack s=new stack();
        Exception e = assertThrows(Exception.class, () -> {Integer a = (Integer) s.pop();});
        assertEquals(e.getMessage(),"Stack is empty");
    }
    @Test
    void func_working_Integer_test() throws Exception {
        stack<Integer> s=new stack();
        s.push((Integer)1);
        s.push((Integer)2);
        s.push((Integer)3);
        Integer x= (Integer) s.pop();
        assert (x==3);
        stack<Integer> a=new stack();
        a=s.popStack(2);
        assert(a.count()==2);
        s.pushStack(a);
        s.push((Integer)3);
        assert(s.count()==3);
    }

}
