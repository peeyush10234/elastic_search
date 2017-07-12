package com.walmart;


import com.walmart.product.model.Product;
import com.walmart.vendor.model.Vendor;
import com.walmart.product.service.ProductService;
import com.walmart.vendor.service.VendorService;
import com.walmart.product.service.ProductServiceImpl;
import com.walmart.vendor.service.VendorServiceImpl;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private VendorService vendorService;
    
    @Autowired
    private ProductService productService;
    

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        printElasticSearchInfo();

      List<Product> productList = new ArrayList<>();
	Vendor vendor = new Vendor("212","akhil tomar","Atomar@walmart.com","7042452391","4.5","delhi","delhi","india");
	Vendor vendor1 = new Vendor("213","ayushi tomar","Aytomar@walmart.com","7842452391","4","delhi","delhi","india");
	String id1=vendor.getVendorID();
	String id2=vendor1.getVendorID();
	
	
       
	productList.add(new Product("11","cucumber","vegetable","15","lucknow","cucumber","23-FEB-2017","29-jul-2017","45.8","89.1","lucknow","up","india",id1));
	productList.add(new Product("12","guava","fruit","85","lucknow","guava","23-FEB-2017","29-jul-2017","45.8","89.1","lucknow","up","india",id1));
	productList.add(new Product("13","Apple","fruit","105","lucknow","apple","23-FEB-2017","29-jul-2017","45.8","89.1","lucknow","up","india",id1));
	productList.add(new Product("14","banana","fruit","115","lucknow","banana","23-FEB-2017","29-jul-2017","45.8","89.1","lucknow","up","india",id1));
	Product product1=new Product("11","cucumber","vegetable","15","lucknow","cucumber","23-FEB-2017","29-jul-2017","45.8","89.1","lucknow","up","india",id2);
	

       for (Product product : productList) {
            productService.save(product);
        }

       productService.save(product1);
    
         
         
         System.out.println(product1.toString());
        // Page<Product> products = productService.findByVendorID("212",new PageRequest(0, 10));
         List<Product> products = productService.findByName("apples");
         products.forEach(x -> System.out.println(x));

        //List<Book> books = bookService.findByTitle("Elasticsearch Basics");

       // products.forEach(x -> System.out.println(x));


    }

    //useful for debug
    private void printElasticSearchInfo() {

        System.out.println("--ElasticSearch-->");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();

        asMap.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
        System.out.println("<--ElasticSearch--");
    }

}
