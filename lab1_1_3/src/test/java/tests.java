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
        Exception e1 = assertThrows(Exception.class, () -> {stack a =  s.popStack(3);});
        assertEquals(e1.getMessage(),"Stack is empty");
    }
    void pop_stack_test() throws Exception{
        stack<Integer> s=new stack();
        s.push(1);
        Exception e = assertThrows(Exception.class, () -> {stack a =  s.popStack(3);});
        assertEquals(e.getMessage(),"Not enough elements in stack");
    }
    @Test
    void func_working_Integer_test() throws Exception {
        stack<Integer> s=new stack();
        s.push((Integer)1);
        s.push((Integer)2);
        s.push((Integer)3);
        Integer x= (Integer) s.pop();
        assert (x==3);
        x=s.pop();
        assert(x==2);
        x=s.pop();
        assert(x==1);
    }
    @Test
    void func2_working_Integer_test() throws Exception{
        stack<Integer> s=new stack();
        stack<Integer> a=new stack();
        Integer x;
        s.push((Integer)1);
        s.push((Integer)2);
        s.push((Integer)3);

        a=s.popStack(2);
        assert(a.count()==2 && s.count()==1);

        x=s.pop();
        assert(x==1);
        s.push(x);

        x=a.pop();
        assert(x==3);
        a.push(x);

        s.pushStack(a);
        assert(s.count()==3);

        x=s.pop();
        assert(x==3);
    }

    @Test
    void func_working_String_test() throws Exception {
        stack<String> s=new stack();
        s.push((String)"1");
        s.push((String)"2");
        s.push((String)"3");
        String x= (String) s.pop();
        assert (x=="3");
        x=s.pop();
        assert(x=="2");
        x=s.pop();
        assert(x=="1");
    }

}
