package com.khoalt.IntroductionEbook.chap20.Ex2003;

public class CapitalCity {
    private String state;
    private String city;

    public CapitalCity(){}

    public CapitalCity(String state, String city) {
        this.state = state;
        this.city = city;
    }

    public String getCity() {return city;}
    public String getState() {return state;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}

    @Override
    public String toString() {
        return state + " " + city;
    }
}
