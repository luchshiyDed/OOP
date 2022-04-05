package JsonReader;


import Pizzeria.PizzeriaConf;
import Workers.Baker.BakerConf;
import Workers.Cureer.CureerConf;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class JsonReader{
    public PizzeriaConf read(String bakers, String cureers) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PizzeriaConf configuration=new PizzeriaConf();
        configuration.BakerConf =  Arrays.asList(mapper.readValue(new File(bakers), BakerConf[].class));
        configuration.CureerConf =  Arrays.asList(mapper.readValue(new File(cureers), CureerConf[].class));
        return configuration;
    }
}
