/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Customer;

/**
 *
 * @author 212017705
 */
public interface CustomerService extends Services<Customer, Long>{
    public String getCustomerAddress(String custNum);
    public String getCustomerCellNumber(String custNum);
}
