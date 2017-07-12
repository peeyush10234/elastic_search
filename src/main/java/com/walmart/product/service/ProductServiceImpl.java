package com.walmart.product.service;
import com.walmart.vendor.model.Vendor;
import com.walmart.product.model.Product;
import com.walmart.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findByVendorID(String vendorID, PageRequest pageRequest) {
        return productRepository.findByVendorID(vendorID, pageRequest);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
