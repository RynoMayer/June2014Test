/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class CustomerInvoice implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal orderAmount;
    private String invoiceStatus;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date invoiceDate;
    
    private CustomerInvoice(){}
    
    private CustomerInvoice(Builder build){
        id=build.id;
        orderAmount=build.orderAmount;
        invoiceStatus=build.invoiceStatus;
        invoiceDate=build.invoiceDate;
    }
    public static class Builder{
        private Long id;
        private BigDecimal orderAmount;
        private String invoiceStatus;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date invoiceDate;
        
        public Builder(Date idate){
            this.invoiceDate=idate;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder orderAmount(BigDecimal orderamount){
            this.orderAmount=orderamount;
            return this;
        }
        
        public Builder invoideStatus(String istatus){
            this.invoiceStatus=istatus;
            return this;
        }
        
        public CustomerInvoice build(){
            return new CustomerInvoice(this);       
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomerInvoice other = (CustomerInvoice) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerInvoice{" + "id=" + id + '}';
    }
    
}
