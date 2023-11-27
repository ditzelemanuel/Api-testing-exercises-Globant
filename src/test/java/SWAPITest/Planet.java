package SWAPITest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
    private String name;
    private String gravity;
    private String terrain;
    private String url;
    }

