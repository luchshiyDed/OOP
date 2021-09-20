package knuttmorrisspratt.pack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Knuttmorrissprat {

    /**
     *
     * @param str the string that we search
     * @return pi-function from str (the length of max prefix of str for each symbol of str)
     */
    public int[] piFunc(String str) {
        int n=str.length();
        int[] pi=new int[n];
        pi[0]=0;
        for (int i=1; i<n; ++i) {
            int j = pi[i-1];
            while (j > 0 && str.charAt(i) !=str.charAt(j))
                j = pi[j-1];
            if (str.charAt(j) == str.charAt(i))
                ++j;
                pi[i] = j;
        }
        return pi;
    }

    /**
     *
     * @param str a string to find in a file
     * @param text file were we search the string
     * @return number of the begining of str in text
     */
    public int knutt_moris_alg(String str,String text) throws IOException {
        int[] p=piFunc(str);
        int m=str.length();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(text));
        int sym = bufferedReader.read();
        int j=0;
        int i;
        for (i=0;sym != -1;i++) {
            char c = (char) sym;
            sym = bufferedReader.read();
            while(j>0&& c != str.charAt(j))
                j = p[j - 1];
            if(c == str.charAt(j))
                j++;
            if(j == m)
            {
                return i - j + 1;
            }
        }
        return -1;
    }
}
