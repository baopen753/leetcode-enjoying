package design_oop.observer_pattern;

import design_oop.observer_pattern.display_element.*;
import design_oop.observer_pattern.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticDisplay statisticDisplay = new StatisticDisplay(weatherData);
        ThirdPartyDisplay thirdPartyDisplay = new ThirdPartyDisplay(weatherData);
        MobileDisplay mobileDisplay = new MobileDisplay(weatherData);

        weatherData.setMeasurement(37, 78, 56);
    }
}
