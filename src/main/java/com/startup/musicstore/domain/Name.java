/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author 212017705
 */
@Embeddable
public class Name implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    private Name(){}
    
    private Name(Builder build){
        id=build.id;
        firstName=build.firstName;
        lastName=build.lastName;
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        
        public Builder(String fname){
            this.firstName=fname;
        }
        
        public Builder LastName(String lname){
            this.lastName=lname;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Name build(){
            return new Name(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name{" + "id=" + id + '}';
    }
    
    
}
