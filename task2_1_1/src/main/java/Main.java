
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    int main() {
        ArrayList<Integer> arr = new ArrayList<>();
        FileReader input;
        {
            try {
                input = new FileReader("input.txt");
                int c;
                while ((c = input.read()) != -1) {
                    arr.add(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Thread a = new PrimeChekerFirst(arr);
        a.start();
        Thread b = new PrimeChekerThread(arr, 8);
        b.start();

    }
}
