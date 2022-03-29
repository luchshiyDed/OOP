package JsonReader;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JsonReader {

    JsonReader(String Bakers,String Cureers) {
        Gson gson = new Gson();
        Reader r = null;
        Reader r1 = null;
        try {
            r = new FileReader(Bakers);
            r1 = new FileReader(Cureers);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
