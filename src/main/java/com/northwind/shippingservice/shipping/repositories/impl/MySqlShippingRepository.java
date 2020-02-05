package com.northwind.shippingservice.shipping.repositories.impl;


import com.northwind.shippingservice.shipping.domain.PackingSlip;
import com.northwind.shippingservice.shipping.repositories.ShippingRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;


public class MySqlShippingRepository implements ShippingRepository {
    private DataSource dataSource;
    private ShippingRowMapper shippingRowMapper;

    private final static String getAddressSql  =
           " SELECT `PackingSlips`.`PackingSlipID`,\n" +
                   "`PackingSlips`.`OrderID`,\n" +
            "`PackingSlips`.`ShipName`,\n" +
            "`PackingSlips`.`ShipAddress`,\n" +
            "`PackingSlips`.`ShipCity`,\n" +
            "`PackingSlips`.`ShipRegion`,\n" +
            "`PackingSlips`.`ShipPostalCode`,\n" +
            "`PackingSlips`.`ShipCountry`,\n" +
            "`PackingSlips`.`Version`,\n" +
            "`PackingSlips`.`ObjectID`\n" +
    " FROM `shipping-db`.`PackingSlips`\n" +
                   " WHERE PackingSlipID = :id";


    public MySqlShippingRepository(DataSource dataSource,
                                   ShippingRowMapper shippingRowMapper){
        this.dataSource = dataSource;
        this.shippingRowMapper = shippingRowMapper;

    }
    @Override
    public List<PackingSlip> findByShipName(String shipName){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        String sql = " SELECT `PackingSlips`.`PackingSlipID`,\n" +
                "`PackingSlips`.`OrderID`,\n" +
                "`PackingSlips`.`ShipName`,\n" +
                "`PackingSlips`.`ShipAddress`,\n" +
                "`PackingSlips`.`ShipCity`,\n" +
                "`PackingSlips`.`ShipRegion`,\n" +
                "`PackingSlips`.`ShipPostalCode`,\n" +
                "`PackingSlips`.`ShipCountry`,\n" +
                "`PackingSlips`.`Version`,\n" +
                "`PackingSlips`.`ObjectID`\n" +
                " FROM `shipping-db`.`PackingSlips`\n" +
                " WHERE ShipName LIKE :shipName";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("shipName", shipName + "%");

        List<PackingSlip> packingSlips = db.query(sql, params, shippingRowMapper);
        return packingSlips;

    }


    @Override
    public PackingSlip getByOrderNo(String orderNo){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        String sql = " SELECT `PackingSlips`.`PackingSlipID`,\n" +
                "`PackingSlips`.`OrderID`,\n" +
                "`PackingSlips`.`ShipName`,\n" +
                "`PackingSlips`.`ShipAddress`,\n" +
                "`PackingSlips`.`ShipCity`,\n" +
                "`PackingSlips`.`ShipRegion`,\n" +
                "`PackingSlips`.`ShipPostalCode`,\n" +
                "`PackingSlips`.`ShipCountry`,\n" +
                "`PackingSlips`.`Version`,\n" +
                "`PackingSlips`.`ObjectID`\n" +
                " FROM `shipping-db`.`PackingSlips`\n" +
                " WHERE OrderID = :orderNo";

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("orderNo", orderNo);

        PackingSlip packingSlip = db.queryForObject(sql, params, shippingRowMapper);
        return packingSlip;
    }
    @Override
    public PackingSlip getById(long id){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        String sql = " SELECT `PackingSlips`.`PackingSlipID`,\n" +
                "`PackingSlips`.`OrderID`,\n" +
                "`PackingSlips`.`ShipName`,\n" +
                "`PackingSlips`.`ShipAddress`,\n" +
                "`PackingSlips`.`ShipCity`,\n" +
                "`PackingSlips`.`ShipRegion`,\n" +
                "`PackingSlips`.`ShipPostalCode`,\n" +
                "`PackingSlips`.`ShipCountry`,\n" +
                "`PackingSlips`.`Version`,\n" +
                "`PackingSlips`.`ObjectID`\n" +
                " FROM `shipping-db`.`PackingSlips`\n" +
                " WHERE PackingSlipID = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        PackingSlip packingSlip = db.queryForObject(sql, params, shippingRowMapper);

       /* if (packingSlip != null){
            List<Address> addresses = db.query(getAddressSql, params, addressRowMapper);
            addresses.stream().forEach(a -> customer.addAddress(a));
        }*/
        return packingSlip;
    }
    @Override
    public List<PackingSlip> getAll(int offSet, int limit){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        String sql = " SELECT `PackingSlips`.`PackingSlipID`,\n" +
                "`PackingSlips`.`OrderID`,\n" +
                "`PackingSlips`.`ShipName`,\n" +
                "`PackingSlips`.`ShipAddress`,\n" +
                "`PackingSlips`.`ShipCity`,\n" +
                "`PackingSlips`.`ShipRegion`,\n" +
                "`PackingSlips`.`ShipPostalCode`,\n" +
                "`PackingSlips`.`ShipCountry`,\n" +
                "`PackingSlips`.`Version`,\n" +
                "`PackingSlips`.`ObjectID`\n" +
                " FROM `shipping-db`.`PackingSlips`";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("offset", offSet)
                .addValue("limit", limit);

        List<PackingSlip> packingSlip = db.query(sql, params, shippingRowMapper);
        return packingSlip;
    }



    @Override
    public PackingSlip save(PackingSlip entity){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("shipName", entity.getShipName())
                .addValue("shipAddress", entity.getShipAddress())
                .addValue("shipCity", entity.getShipCity())
                .addValue("shipPostalCode", entity.getShipPostalCode())
                .addValue("shipRegion", entity.getShipRegion())
                .addValue("shipCountry", entity.getShipCountry());
        if (entity.getId() == 0){
            //insert
            String sql = "INSERT INTO `shipping-db`.`PackingSlipID`\n" +
                    "(`OrderID`,`ShipName`,`ShipAddress`,`ShipCity`,`ShipRegion`,`ShipPostalCode,`ShipCountry`,`Version`)\n" +
                    "VALUES(:orderid,:shipName, :shipaddress, :shipcity, :shipregion, :shippostalcode, :shipcountry, :version)";

            KeyHolder keyHolder = new GeneratedKeyHolder();
            db.update(sql, params, keyHolder);
            MapSqlParameterSource idParams = new MapSqlParameterSource();
            return getById(keyHolder.getKey().longValue());
        }else{
            //update
            String sql = "UPDATE `shipping-db`.`Customers`\n" +
                    "SET `OrderID` = :orderID,\n" +
                    "`ShipName` = :shipName,\n" +
                    "`ShipAddress` = :shipAddress,\n" +
                    "`ShipCity` = :shipCity,\n" +
                    "`ShipRegion` = :shipRegion,\n" +
                    "`ShipPostalCode` = :shipPostalCode,\n" +
                    "`ShipCountry =: shipCountry,\n"+
                    "`Version` = Version + 1\n" +
                    "WHERE `PackingSlipID` = :id and Version = :version";
            params.addValue("id", entity.getId())
                    .addValue("version", entity.getVersion());

            int rowsAffected = db.update(sql, params);
            if (rowsAffected == 0){
                throw new IllegalStateException("Concurrent modification detected");
            }
            return getById(entity.getId());
        }

    }
    @Override
    public void delete(long id){
        NamedParameterJdbcTemplate db = new NamedParameterJdbcTemplate(dataSource);
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
        db.update("delete from Shipping where PackingSlipID = :id", params);
    }


}
