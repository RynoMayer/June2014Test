/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class OrderItem implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Album album;
    private int quantity;
    
    private OrderItem(){}
    
    private OrderItem(Builder build){
        id=build.id;
        quantity=build.quantity;
        album=build.album;
    }
    
    public static class Builder{
        private Long id;
        private int quantity;
        private Album album;
        
        public Builder(int qty){
            this.quantity=qty;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder album(Album alb){
            this.album=alb;
                    return this;
        }
        
        public OrderItem build(){
            return new OrderItem(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + '}';
    }
    
}
