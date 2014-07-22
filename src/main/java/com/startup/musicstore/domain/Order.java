/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int orderNumber;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderDate;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="Order_id")
    private List<OrderItem> orderItem;
    
    private Order(){}
    
    private Order(Builder build){
        id=build.id;
        orderNumber=build.orderNumber;
        orderDate=build.orderDate;
        orderItem=build.orderItem;
    }
    
    public static class Builder{
        private Long id;
        private int orderNumber;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date orderDate;
        private List<OrderItem> orderItem;
        
        public Builder(int onum){
            this.orderNumber=onum;
        }
        
        public Builder orderDate(Date odate){
            this.orderDate=odate;
            return this;
        }
        
        public Builder orderItem(List<OrderItem> oitem){
            this.orderItem=oitem;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Order build(){
            return new Order(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderItem=" + orderItem + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
