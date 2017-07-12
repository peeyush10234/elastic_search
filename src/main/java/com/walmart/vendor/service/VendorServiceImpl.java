package com.walmart.vendor.service;
import com.walmart.vendor.model.Vendor;
//import com.walmart.product.model.Product;
import com.walmart.vendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepository;

    @Autowired
    public void setVendorRepository(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void delete(Vendor vendor) {
        vendorRepository.delete(vendor);
    }

    public Vendor findOne(String id) {
        return vendorRepository.findOne(id);
    }

    public Iterable<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Page<Vendor> findByState(String state, PageRequest pageRequest) {
        return vendorRepository.findByState(state, pageRequest);
    }

    public List<Vendor> findByName(String name) {
        return vendorRepository.findByName(name);
    }

}
