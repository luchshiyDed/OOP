import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
