import notebook.Notebook;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class test {
    @Test
    void func_test(){
        Notebook a = new Notebook( "test.json");
        a.addNote("a","a");
        ArrayList<Notebook.Note> x = a.readNotes();
        assert(x.get(0).noteText().equals("a"));
        assert(x.get(0).noteTitle().equals("a"));
        a.removeNote("a");
        x=a.readNotes();
        assert(x.isEmpty());
    }
}