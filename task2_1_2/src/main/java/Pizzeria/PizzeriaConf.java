package Pizzeria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class PizzeriaConf {
    @JsonProperty("wt")
    @Getter
    private Integer WT;
    @JsonProperty("stSize")
    @Getter
    private Integer stSize;
    @JsonProperty("BakerConf")
    @Getter
    private List<Workers.Baker.BakerConf> BakerConf;
    @JsonProperty("CureerConf")
    @Getter
    private List<Workers.Cureer.CureerConf> CureerConf;
}
