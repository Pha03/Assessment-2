package com.northwind.shippingservice.shipping.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackingSlip {
    private long id;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    private long version;
    private int orderNo;
    private List<PackingSlipDetails> addItem = new ArrayList<>();

    public PackingSlip(String shipName) {
        setShipName(shipName);
    }
    public PackingSlip (long id, String shipName)
    {
        this(shipName);
        setId(id);
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

    public void setShipName(String shipName){
        if (shipName == null ){
            throw new IllegalArgumentException("shipName is required.");
        }
        String cleanName = shipName.trim();
        if (cleanName.length() == 0 || cleanName.length() > 50){
            throw new IllegalArgumentException("shipName must be between 1 and 50 characters.");
        }
        this.shipName = cleanName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        String cleanAddress = null;
        if (shipAddress != null){
            cleanAddress = shipAddress.trim();
        }
        if (cleanAddress != null && (cleanAddress.length() == 0 || cleanAddress.length() > 60)){
            throw new IllegalArgumentException("ShipAddress must be between 1 and 60 characters.");
        }
        this.shipAddress = shipAddress;
    }
    public long getVersion() { return version;}

    public void setVersion(long version){
        if(version == 0)
            throw new IllegalArgumentException("Version cannot be zero.");

        if(version<this.version)
            throw new IllegalArgumentException("Version cannot be older than the current version");

        this.version = version;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        String cleanCity = null;
        if (shipCity != null){
            cleanCity = shipCity.trim();
        }
        if (cleanCity != null && (cleanCity.length() == 0 || cleanCity.length() > 30)){
            throw new IllegalArgumentException("ShipCity must be between 1 and 30 characters.");
        }
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        String cleanRegion = null;
        if (shipRegion != null){
            cleanRegion = shipRegion.trim();
        }
        if (cleanRegion != null && (cleanRegion.length() == 0 || cleanRegion.length() > 24)){
            throw new IllegalArgumentException("ShipRegion must be between 1 and 24 characters.");
        }
            this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        String cleanPostalCode = null;
        if (shipPostalCode != null){
            cleanPostalCode = shipPostalCode.trim();
        }
        if (cleanPostalCode != null && (cleanPostalCode.length() == 0 || cleanPostalCode.length() > 24)){
            throw new IllegalArgumentException("ShipPostalCode must be between 1 and 24 characters.");
        }
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        String cleanCountry = null;
        if (shipCountry != null){
            cleanCountry = shipCountry.trim();
        }
        if (cleanCountry != null && (cleanCountry.length() == 0 || cleanCountry.length() > 24)){
            throw new IllegalArgumentException("ShipCountry must be between 1 and 24 characters.");
        }
        this.shipCountry = shipCountry;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public List<PackingSlipDetails> getAddItem(){
        return Collections.unmodifiableList(addItem);
    }

    public void addItem(PackingSlipDetails addItems){
        addItem.add(addItems);
    }



}
