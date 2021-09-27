import knuttmorrisspratt.pack.Knuttmorrissprat;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.assertNotNull;

public class test {
    @Test
    public void test_in_the_begining() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello", "test.txt");
        assert(a[0]==0);
    }
    @Test
    public void test_no_file() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Throwable thrown = assertThrows(IOException.class, () -> {Integer[] a =main.knutt_moris_alg("hello", "testX.txt");});
        assertNotNull(thrown.getMessage());

    }
    @Test
    public void test_null_string() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("", "test.txt");
        assert(a==null);
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
    public void test_full_string() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello I'm Jon. Hi I am Peter. There is a frog. Frog eats people. !", "test.txt");
        assert(a[0]==0);
    }
    @Test
    public void test_bigger_string() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("hello I'm Jon. Hi I am Peter. There is a frog. Frog eats people. !!", "test.txt");
        assert(a==null);
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
    public void test_multipe_enterings() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg(". ", "test.txt");
        assert(a[0]==13 && a[1]==28 && a[2]==45 && a[3]==63);
    }
    @Test
    public void test_large_file() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("abv", "test_3.txt");
        assert(a[0]==14400000);
    }
    @Test
    public void test_when_string_is_substring() throws IOException {
        Knuttmorrissprat main = new Knuttmorrissprat();
        Integer[] a =main.knutt_moris_alg("aabaab", "test2.txt");
        assert(a[0]==0 &&a[1]==10 && a[2]==13 && a[3]==16);
    }

}