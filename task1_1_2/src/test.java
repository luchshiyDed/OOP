import knuttmorrisspratt.pack.Knuttmorrissprat;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class test {
    @Test
    public void test_in_the_begining() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello", "test.txt");
        assert(a[0]==0);
    }
    @Test
    public void test_in_the_middle() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("Hi I am Peter", "test.txt");
        assert(a[0]==15);
    }
    @Test
    public void test_in_the_end() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("Frog eats people.", "test.txt");
        assert(a[0]==47);
    }
    @Test
    public void test_in_the_errorString() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("Hi I am Peterr", "test.txt");
        assert(a==null);
    }
    @Test
    public void test_in_the_emptyFile() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello", "test1.txt");
        assert(a==null);
    }
    @Test
    public void test_multipe_enerings() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg(". ", "test.txt");
        assert(a[0]==13 && a[1]==28 && a[2]==45 && a[3]==63);
    }

}
