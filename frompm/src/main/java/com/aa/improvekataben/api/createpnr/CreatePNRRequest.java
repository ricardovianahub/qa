package com.aa.improvekataben.api.createpnr;

public class CreatePNRRequest {
    private String originCity;
    private String destinationCity;
    private String phone;
    private String name;
    private String departureDate;

    public String getOriginCity() {
        return originCity;
    }

    public CreatePNRRequest setOriginCity(String originCity) {
        this.originCity = originCity;
        return this;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public CreatePNRRequest setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreatePNRRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreatePNRRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public CreatePNRRequest setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }
}
