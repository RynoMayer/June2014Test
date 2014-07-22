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
@Embeddable
public class Contact implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    private String cellNumber;
    
    private Contact(){}
    
    private Contact(Builder build){
        id=build.id;
        phoneNumber=build.phoneNumber;
        cellNumber=build.cellNumber;
    }
    
    public static class Builder{
        private Long id;
        private String phoneNumber;
        private String cellNumber;
        
        public Builder(String cnum){
            this.cellNumber=cnum;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder phonenumber(String pnum){
            this.phoneNumber=pnum;
            return this;
        }
        
        public Contact build(){
            return new Contact(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + '}';
    }
    
}
