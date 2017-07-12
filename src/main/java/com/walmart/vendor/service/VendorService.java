package com.walmart.vendor.service;

import com.walmart.vendor.model.Vendor;
//import com.walmart.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VendorService {

    Vendor save(Vendor vendor);

    void delete(Vendor vendor);

    Vendor findOne(String id);

    Iterable<Vendor> findAll();

    Page<Vendor> findByState(String state, PageRequest pageRequest);
    List<Vendor> findByName(String name);
}
