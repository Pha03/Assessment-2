package com.northwind.shippingservice.shipping;


import com.northwind.shippingservice.shipping.repositories.ShippingRepository;
import com.northwind.shippingservice.shipping.repositories.impl.MySqlShippingRepository;
import com.northwind.shippingservice.shipping.repositories.impl.ShippingRowMapper;
import com.northwind.shippingservice.shipping.services.PackingSlipServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.northwind.shippingservice"})
public class AppConfig {
    @Bean
    public DataSource datasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shipping-db");
        dataSource.setUsername("shipping-user");
        dataSource.setPassword("password");

        return dataSource;
    }
    //DI Configuration goes here.
    @Bean
    public PackingSlipServices packingSlipServices(ShippingRepository shippingRepository){
        return new PackingSlipServices(shippingRepository);
    }
    @Bean
    public ShippingRepository shippingRepository(DataSource dataSource,
                                                 ShippingRowMapper shippingRowMapper){
        return new MySqlShippingRepository(dataSource, shippingRowMapper );
    }
    @Bean

    public ShippingRowMapper shippingRowMapper() {
        return new ShippingRowMapper();
    }

}
