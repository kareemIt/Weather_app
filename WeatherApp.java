import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {
    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String city = " ";
        while(city != null) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("What city are you in?");
                city = in.nextLine();
                URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=d8df22578e5d4dc0004f44f56cf86dec");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept", "application/json");
                InputStream responseStream = connection.getInputStream();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                WeatherAndTemperature currentWeather = mapper.readValue(responseStream, WeatherAndTemperature.class);
                double currentKelvin = currentWeather.currentTemp.getTemp();
                System.out.println("Hello, In " + city + " the current temperature is " + toFahreheit(currentKelvin) + " degrees with a humidity of " + currentWeather.getCurrentTemp().getHumidity()
                        + ".The weather description currently is " + currentWeather.getDescription() + ". Have a nice day.");
            } catch (Exception e) {
                System.out.println("Sorry that is not a city try again");

            }
        }

    }
    public static double toFahreheit(double x){
        return Math.ceil((((x - 273.15) * 9) /5) +32);
    }

}
