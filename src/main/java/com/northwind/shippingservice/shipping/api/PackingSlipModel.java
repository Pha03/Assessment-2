package com.northwind.shippingservice.shipping.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize
public class PackingSlipModel {
    @JsonProperty
    private long id;
    @JsonProperty
    private String shipName;
    @JsonProperty
    private String shipAddress;
    @JsonProperty
    private String shipCity;
    @JsonProperty
    private String shipRegion;
    @JsonProperty
    private String shipPostalCode;
    @JsonProperty
    private String shipCountry;
    @JsonProperty
    private int orderNo;
    @JsonProperty
    private long version;
    @JsonProperty
    private List<Link> links = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName){ this.shipName = shipName; }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress){ this.shipAddress = shipAddress; }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity){ this.shipCity = shipCity; }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion){ this.shipRegion = shipRegion; }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode){ this.shipPostalCode = shipPostalCode; }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry){ this.shipCountry = shipCountry; }

    public int getOrderNo() { return orderNo; }

    public void setOrderNo(int orderNo) { this.orderNo = orderNo; }

    public long getVersion() { return version;}

    public void setVersion(long version) {this.version = version;}






}
