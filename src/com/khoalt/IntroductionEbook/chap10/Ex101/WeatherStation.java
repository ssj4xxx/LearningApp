package com.khoalt.IntroductionEbook.chap10.Ex101;

public class WeatherStation {
    private double temperature, pressure;

    public WeatherStation() {
        temperature = 0;
        pressure = 1;
    }

    public WeatherStation(double temperature, double pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public static WeatherStation fromImperial(double temperatureFahrenheit, double pressurePSI) {
        double temperature = (temperatureFahrenheit - 32) / 1.8;
        double pressure = pressurePSI / 14.5038;
        WeatherStation weatherStation = new WeatherStation(temperature, pressure);
        return weatherStation;
    }

    public double getTemperature() {
        return temperature;
    }
    public double getPressure() {
        return pressure;
    }
    public double getTemperatureFahrenheit() {
        return temperature * 1.8 + 32;
    }
    public double getPressurePSI() {
        return pressure * 14.5038;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setPressure(double newPressure) {
        pressure = (newPressure >= 0) ? newPressure : 1;
    }
    public void setTemperatureFahrenheit(double temperature) {
        this.temperature = temperature * 1.8 + 32;
    }
    public void setPressurePSI(double newPressure) {
        pressure = (newPressure >= 0) ? newPressure * 14.5038 : 1;
    }
}
