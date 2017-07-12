package com.walmart.vendor.repository;
import com.walmart.vendor.model.Vendor;
//import com.walmart.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface VendorRepository extends ElasticsearchRepository<Vendor, String> {

    Page<Vendor> findByState(String state, Pageable pageable);
    List<Vendor> findByName(String name);

}
