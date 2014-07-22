/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.CustomerInvoice;
import java.math.BigDecimal;

/**
 *
 * @author 212017705
 */
public interface OrderAmountService extends Services <CustomerInvoice, Long>{
    public BigDecimal calcorderAmount(int ordernum);
}
