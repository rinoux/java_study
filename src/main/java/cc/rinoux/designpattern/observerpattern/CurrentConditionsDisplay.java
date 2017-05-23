package cc.rinoux.designpattern.observerpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by rinoux on 2017/3/13.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.temperature = ((WeatherData) o).getTemperature();
            this.humidity = ((WeatherData) o).getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "C degrees and " + humidity + "% humidity");
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay(weatherData);
        System.out.println("weather data would changed");
        weatherData.setMeasurements(100, 24, 100);
        //display.display();

    }
}
