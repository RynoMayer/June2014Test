/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class CustomerAddress implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetAddress;
    private String postboxAdress;
    
    private CustomerAddress(){}
    
    private CustomerAddress(Builder build){
        id=build.id;
        streetAddress=build.streetAddress;
        postboxAdress=build.postboxAdress;
    }
    public static class Builder{
        private Long id;
        private String streetAddress;
        private String postboxAdress;
        
        public Builder(String streetAddress){
            this.streetAddress=streetAddress;
        }
        
        public Builder postboxAdress(String postboxAdress){
            this.postboxAdress=postboxAdress;
            return this;
        }
        
        public CustomerAddress build(){
            return new CustomerAddress(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostboxAdress() {
        return postboxAdress;
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
        final CustomerAddress other = (CustomerAddress) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" + "id=" + id + '}';
    }
    
}
