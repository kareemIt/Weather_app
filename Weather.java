import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Weather {
    @JsonProperty("main")
    private String main;

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                '}';
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}

