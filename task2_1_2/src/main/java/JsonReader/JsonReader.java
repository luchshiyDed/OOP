package JsonReader;


import Pizzeria.PizzeriaConf;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader{
    public static PizzeriaConf read(String config) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PizzeriaConf configuration=mapper.readValue(new File(config), PizzeriaConf.class);
        return configuration;
    }
}
