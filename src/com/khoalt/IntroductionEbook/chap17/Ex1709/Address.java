package com.khoalt.IntroductionEbook.chap17.Ex1709;

class Address {
    private String name, street, city, state;
    private int zip;

    public Address() {}

    public Address(String name, String street, String city, String state, int zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {return name;}
    public String getStreet() {return street;}
    public String getCity() {return city;}
    public String getState() {return state;}
    public int getZip() {return zip;}

    public void setName(String name) {this.name = name;}
    public void setStreet(String street) {this.street = street;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setZip(int zip) {this.zip = zip;}
}
