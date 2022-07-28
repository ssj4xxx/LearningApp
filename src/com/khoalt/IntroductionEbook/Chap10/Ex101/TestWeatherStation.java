package com.khoalt.IntroductionEbook.Chap10.Ex101;

import java.util.Scanner;

public class TestWeatherStation {

    public static void main(String[] args) {
        WeatherStation weatherStation1 = new WeatherStation();
        WeatherStation weatherStation2 = new WeatherStation(35, 0.5);
        WeatherStation weatherStation3 = WeatherStation.fromImperial(68, 21);

        displayMetricUnit(weatherStation1);
        displayImperialUnit(weatherStation1);
        displayMetricUnit(weatherStation2);
        displayImperialUnit(weatherStation2);
        displayMetricUnit(weatherStation3);
        displayImperialUnit(weatherStation3);
    }

    public static void displayMetricUnit(WeatherStation weatherStation) {
        System.out.println(weatherStation.getTemperature() + "°C, " + weatherStation.getPressure() + " bar");
    }

    public static void displayImperialUnit(WeatherStation weatherStation) {
        System.out.println(weatherStation.getTemperatureFahrenheit() + "°F, " + weatherStation.getPressurePSI() + " PSI");
    }
}
