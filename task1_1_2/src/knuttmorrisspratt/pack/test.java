package knuttmorrisspratt.pack;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class test {
    @Test
    public void test_in_the_begining() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        int a =main.knutt_moris_alg("hello", "test.txt");
        assert(a==0);
    }
    @Test
    public void test_in_the_middle() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        int a =main.knutt_moris_alg("Hi I am Peter", "test.txt");
        assert(a==15);
    }
    @Test
    public void test_in_the_end() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        int a =main.knutt_moris_alg("Frog eats people.", "test.txt");
        assert(a==47);
    }
    @Test
    public void test_in_the_errorString() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        int a =main.knutt_moris_alg("Hi I am Peterr", "test.txt");
        assert(a==-1);
    }
    @Test
    public void test_in_the_emptyFile() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
       int a =main.knutt_moris_alg("hello", "test1.txt");
        assert(a==-1);
    }
}
