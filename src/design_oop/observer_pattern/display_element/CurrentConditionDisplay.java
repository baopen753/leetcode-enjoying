package design_oop.observer_pattern.display_element;

import design_oop.observer_pattern.observer.Observer;
import design_oop.observer_pattern.subject.WeatherData;

public class CurrentConditionDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;


    /**
     * The constructor is passed the {@code WeatherData} (the Subject)
     * and used ot register as an observer
     *
     * @param weatherData
     */
    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition: " + temperature + " C degree and humidity: " + humidity + " and pressure: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
