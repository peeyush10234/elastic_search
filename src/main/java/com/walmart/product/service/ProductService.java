package com.walmart.product.service;

import com.walmart.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product save(Product product);

    void delete(Product product);

    Product findOne(String id);

    Iterable<Product> findAll();

    Page<Product> findByVendorID(String vendorID, PageRequest pageRequest);

    List<Product> findByName(String name);
}
