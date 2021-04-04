import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class WeatherAndTemperature {
    @JsonProperty("weather")
    Weather[] currentWeather;
    @JsonProperty("main")
    Temperature currentTemp;

    @Override
    public String toString() {
        return "WeatherAndTemperature{" +
                "currentWeather=" + Arrays.toString(currentWeather) +
                ", currentTemp=" + currentTemp +
                '}';
    }

    public Weather[] getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(Weather[] currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Temperature getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Temperature currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getDescription(){
        String description = "";
        for (int i = 0; i <currentWeather.length;i++){
            if (currentWeather.length == 1){
                return description += currentWeather[i].getMain();
            }
            if (i == currentWeather.length-1){
                return description += currentWeather[i].getMain();

            }
            else {
                description += currentWeather[i].getMain()+ ",";
            }
        }
        return description;
    }
}
