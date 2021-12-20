import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class tests {
    @Test
    void add_remove_test(){
        MyTree<Integer> a = new MyTree<Integer>();
        a.add(1,1);
        a.add(2,2,1);
        a.add(3,3,2);
        a.add(4,4,2);
        a.add(5,5,2);
        ArrayList<String> arr=new ArrayList();
        a.forEach(x->arr.add(x.toString()));
        String[] act={"(1,1)","(2,2)","(3,3)","(4,4)","(5,5)"};
        assertArrayEquals(act,arr.toArray());
        a.remove(4);
        act= new String[]{"(1,1)","(2,2)","(3,3)","(5,5)"};
        arr.clear();
        a.forEach(x->arr.add(x.toString()));
        assertArrayEquals(act,arr.toArray());
    }
    @Test
    void removing_non_existing_node(){
        MyTree<Integer> a = new MyTree<Integer>();
        Exception e = assertThrows(Exception.class, () -> {a.remove(1);});
        assertEquals(e.getMessage(),"No such node");
        a.add(1,1);
        Exception e1 = assertThrows(Exception.class, () -> {a.remove(2);});
        assertEquals(e1.getMessage(),"No such node");
    }
    @Test
    void adding_second_key(){
        MyTree<String> a= new MyTree<String>();
        a.add(1,"a");
        Exception e = assertThrows(Exception.class, () -> {a.add(1,"b");});
        assertEquals(e.getMessage(),"Keys must be unique for each value");
    }
    @Test
    void adding_to_an_non_existing_parent(){
        MyTree<String> a= new MyTree<String>();
        a.add(1,"a");
        Exception e = assertThrows(Exception.class, () -> {a.add(2,"b",3);});
        assertEquals(e.getMessage(),"No such parent node");
    }
}
