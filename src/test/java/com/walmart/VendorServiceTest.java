package com.walmart;
import com.walmart.vendor.model.Vendor;
import com.walmart.vendor.service.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VendorServiceTest {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Vendor.class);
        esTemplate.createIndex(Vendor.class);
        esTemplate.putMapping(Vendor.class);
        esTemplate.refresh(Vendor.class);
    }

    @Test
    public void testSave() {

        Vendor vendor = new Vendor("212","akhil tomar","Atomar@walmart.com","7042452391","4.5","delhi","delhi","india");
        Vendor testvendor = vendorService.save(vendor);
	

        assertNotNull(testvendor.getVendorID());
        assertEquals(testvendor.getName(), vendor.getName());
        assertEquals(testvendor.getPhone(), vendor.getPhone());
            // add unique assertions to check efficiently..
    }

    @Test
    public void testFindOne() {

       Vendor vendor = new Vendor("212","akhil tomar","Atomar@walmart.com","7042452391","4.5","delhi","delhi","india");
         vendorService.save(vendor);

        Vendor testvendor = vendorService.findOne(vendor.getVendorID());
     //   System.out.println(testvendor.toString());
        assertNotNull(testvendor.getVendorID());
        assertEquals(testvendor.getName(), vendor.getName());
        assertEquals(testvendor.getPhone(), vendor.getPhone());

        

    }

    @Test
    public void testFindByName() {

        Vendor vendor = new Vendor("212","akhil tomar","Atomar@walmart.com","7042452391","4.5","delhi","delhi","india");
        Vendor testvendor = vendorService.save(vendor);

        List<Vendor> byName = vendorService.findByName(vendor.getName());
        assertThat(byName.size(), is(1));
    }

 
    @Test
    public void testDelete() {

        Vendor vendor = new Vendor("212","akhil tomar","Atomar@walmart.com","7042452391","4.5","delhi","delhi","india");
        vendorService.save(vendor);
       // System.out.println(vendor.toString());
        vendorService.delete(vendor);
        Vendor testvender = vendorService.findOne(vendor.getVendorID());
        assertNull(testvender);
    }

}
