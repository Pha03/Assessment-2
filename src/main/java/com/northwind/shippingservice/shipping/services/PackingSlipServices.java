package com.northwind.shippingservice.shipping.services;



import com.northwind.shippingservice.shipping.domain.PackingSlip;
import com.northwind.shippingservice.shipping.repositories.ShippingRepository;

import java.util.List;


public class PackingSlipServices {
    private ShippingRepository repository;

    public PackingSlipServices(ShippingRepository repository) {
        this.repository = repository;
    }

    public PackingSlip getById(long id) {
        return repository.getById(id);
    }

    public List<PackingSlip> getAll(int offset, int limit) {
        return repository.getAll(offset, limit);
    }

    public List<PackingSlip> findByShipName(String shipName) {
        return repository.findByShipName(shipName);
    }

    public void delete(PackingSlip shipping) {
        repository.delete(shipping.getId());
    }

    public PackingSlip save(PackingSlip shipping){
        PackingSlip savedShipping = repository.save(shipping);
       /* if(savedShipping.getOrderNo() == 0){
            savedShipping.();
            return repository.save(savedShipping);
        }*/
        return savedShipping;
    }
    /*public PackingSlip addItem(long id, PackingSlip addItem) {
        return repository.addItem(Id, addItem);

    }*/
}
