import knuttmorrisspratt.pack.Knuttmorrissprat;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class test {
    @Test
    public void test_no_file() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        IOException e = assertThrows(IOException.class, () -> {Integer[] a =main.knutt_moris_alg("hello", "testX.txt");});
        assertEquals("testX.txt (Не удается найти указанный файл)",  e.getMessage());
    }
    @Test
    public void test_null_string() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Knuttmorrissprat.NoStringFoundExeption e = assertThrows(Knuttmorrissprat.NoStringFoundExeption.class, () ->
        {Integer[] a =main.knutt_moris_alg("", "test.txt");});
        assertEquals("The substring is empty",  e.getMessage());
    }
    @Test
    public void test_full_string() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello I'm Jon. Hi I am Peter. There is a frog. Frog eats people. !", "test.txt");
        assert(a[0]==0);
    }
    @Test
    public void test_in_the_errorString() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("Hi I am Peterr", "test.txt");
        Integer[] b={};
        assertEquals(a,b);
    }
    @Test
    public void test_in_the_emptyFile() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello", "test1.txt");
        Integer[] b={};
        assertEquals(a,b);
    }
    @Test
    public void test_large_file() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("abv", "test_3.txt");
        assert(a[0]==14400000);
    }
    @Test
    public void test_when_string_is_substring() throws IOException, Knuttmorrissprat.NoStringFoundExeption {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("aabaab", "test2.txt");
        assert(a[0]==0 &&a[1]==10 && a[2]==13 && a[3]==16);
    }

}