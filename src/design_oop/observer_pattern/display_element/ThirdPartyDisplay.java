package design_oop.observer_pattern.display_element;

import design_oop.observer_pattern.observer.Observer;
import design_oop.observer_pattern.subject.WeatherData;

public class ThirdPartyDisplay implements DisplayElement, Observer {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public ThirdPartyDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Third Party conditions: " + temperature + " C degree and humidity: " + humidity + " and pressure: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
