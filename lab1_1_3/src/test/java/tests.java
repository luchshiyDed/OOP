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
        Integer[] a = {1, 2, 3};
        s.pushStack(a);
        assert (s.count()==5);
        Integer x= (Integer) s.pop();
        assert (x==3);
        stack<Integer> m=s.popStack(4);
        Object[] c=m.arr;
        Object[] b=new Object[]{1,2, 1, 2};
        assert(c[0]==b[0] && c[1]==b[1] && c[2]==b[2] && c[3]==b[3]);
        assert(m.count()==4);
        x= m.pop();
        assert(x==2&& m.count()==3);
    }
    @Test
    void func_working_String_test() throws Exception{
        stack<String> s=new stack();
        s.push((String)"1");
        s.push((String)"2");
        String[] a = {"1", "2", "3"};
        s.pushStack(a);
        assert (s.count()==5);
        String x= (String) s.pop();
        assert (x=="3");
        stack<Integer> m=s.popStack(4);
        Object[] c=m.arr;
        Object[] b=new Object[]{"1","2", "1", "2"};
        assert(c[0]==b[0] && c[1]==b[1] && c[2]==b[2] && c[3]==b[3]);
    }


}
