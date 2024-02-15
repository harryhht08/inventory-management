package com.example.inventorymanagement.model;

public class ShippingDetails {
    private String address;
    private String carrier; // Example: UPS, FedEx, etc.

    // Constructors
    public ShippingDetails() {}

    public ShippingDetails(String address, String carrier) {
        this.address = address;
        this.carrier = carrier;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
