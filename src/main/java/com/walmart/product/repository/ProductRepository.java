package com.walmart.product.repository;

import com.walmart.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Page<Product> findByVendorID(String vendorId, Pageable pageable);
    List<Product> findByName(String name);

}

