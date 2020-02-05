package com.northwind.shippingservice.shipping.repositories.impl;

import com.northwind.shippingservice.shipping.domain.PackingSlip;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShippingRowMapper implements RowMapper<PackingSlip> {
    @Override
    public PackingSlip mapRow(ResultSet rs, int rowNum) throws SQLException{
        PackingSlip shipping = new PackingSlip(rs.getString("ShipName"));
        shipping.setId(rs.getLong("PackingSlipID"));
        shipping.setOrderNo(rs.getInt("OrderID"));
        shipping.setShipAddress(rs.getString("ShipAddress"));
        shipping.setShipCity(rs.getString("ShipCity"));
        shipping.setShipRegion(rs.getString("ShipRegion"));
        shipping.setShipPostalCode(rs.getString("ShipPostalCode"));
        shipping.setShipCountry(rs.getString("ShipCountry"));
        shipping.setVersion(rs.getLong("Version"));

        return shipping;
    }

}
