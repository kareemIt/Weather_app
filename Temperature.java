import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Temperature {
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("humidity")
    private double humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temp=" + temp +
                ", humidity=" + humidity +
                '}';
    }
}
