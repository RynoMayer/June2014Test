/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.respository.CustomerRepo;
import com.startup.musicstore.services.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 212017705
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo custRepo;
    
    
    @Override
    public String getCustomerAddress(String custNum) {
          Customer custs = null;
        List<Customer> customers = findAll();
        for (Customer customer : customers) {
            if (custNum.equalsIgnoreCase(customer.getCustomerNumber())) {
                custs = customer;
            }
        }
        return custs.getCustomerAddress().getStreetAddress();
    }

    @Override
    public String getCustomerCellNumber(String custNum) {
         Customer custs = null;
         List<Customer> customers = findAll();
         for (Customer customer : customers) {
            if (custNum.equalsIgnoreCase(customer.getCustomerNumber())) {
                custs = customer;
            }
        }
        return custs.getContact().getCellNumber();
    }

    @Override
    public Customer find(Long id) {
        return custRepo.findOne(id);
        
    }

    @Override
    public Customer persist(Customer entity) {
        return custRepo.save(entity);
    }

    @Override
    public Customer merge(Customer entity) {
        if(entity.getId()!= null){
            return custRepo.save(entity);
        }
        
        return null;
    }

    @Override
    public void remove(Customer entity) {
       custRepo.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
       return custRepo.findAll();
    
    }
    
}
