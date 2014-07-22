/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.respository.CustomerRepo;
import com.startup.musicstore.services.CustomerService;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.services.CreditCardSampleServiceTest.ctx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212017705
 */
public class CustomerServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    
   private CustomerService custService;
    public CustomerServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testGetCustomer() {
         custService=ctx.getBean(CustomerService.class);
         Contact cont1= new Contact
                 .Builder("03654687")
                 .build();
         
         CustomerAddress custAddr = new CustomerAddress.Builder("75 there").build();
         
         Customer cust1 = new Customer.Builder("5486")
                 .contact(cont1)
                 .customerAddress(custAddr)
                 .build();
         
         id=cust1.getId();
         custService.persist(cust1);
         String addr = custService.getCustomerAddress("5486");
         String cell = custService.getCustomerCellNumber("5486");
         
         Assert.assertEquals(cell, "03654687");
         Assert.assertEquals(addr, "75 there");
         
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
