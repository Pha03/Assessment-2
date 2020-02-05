package com.northwind.shippingservice.shipping.api;


import com.northwind.shippingservice.shipping.domain.PackingSlip;

class PackingSlipMapper {

    private PackingSlipMapper() {}

    public static PackingSlipModel toModel(PackingSlip entity){
        PackingSlipModel model = new PackingSlipModel();
        model.setId(entity.getId());
        model.setShipName(entity.getShipName());
        model.setShipAddress(entity.getShipAddress());
        model.setShipCountry(entity.getShipCountry());
        model.setShipCity(entity.getShipCity());
        model.setShipRegion(entity.getShipRegion());
        model.setShipPostalCode(entity.getShipPostalCode());
        model.setOrderNo(entity.getOrderNo());
        model.setVersion(entity.getVersion());



        Link addressLink = new Link();
        addressLink.setHref(String.format("/shipping/%d/", entity.getId()));
        model.getLinks().add(addressLink);
        return model;
    }

    public static PackingSlip toEntity(PackingSlipModel model){
        PackingSlip entity = new PackingSlip(model.getShipName());
        entity.setId(model.getId());
        entity.setShipName(model.getShipName());
        entity.setShipAddress(model.getShipAddress());
        entity.setShipCountry(model.getShipCountry());
        entity.setShipCity(model.getShipCity());
        entity.setShipRegion(model.getShipRegion());
        entity.setShipPostalCode(model.getShipPostalCode());
        entity.setOrderNo(model.getOrderNo());
        entity.setVersion(model.getVersion());

        return  entity;
    }

    public static PackingSlip toEntity(PackingSlipModel model, PackingSlip packingSlip){
        PackingSlip packingSlip1 = new PackingSlip(model.getShipName());
        return packingSlip1;
    }
}
