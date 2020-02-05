package com.northwind.shippingservice.shipping.repositories;

import com.northwind.shippingservice.shipping.domain.PackingSlip;

import java.util.List;

public interface ShippingRepository extends Repository<PackingSlip> {

    PackingSlip getByOrderNo(String OrderNo);
    List<PackingSlip> findByShipName(String shipName);

}
