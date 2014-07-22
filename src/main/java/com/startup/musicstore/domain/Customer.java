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
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    @OneToOne
    private Name name;
    @OneToOne
    private Demographic demographic;
    @OneToOne
    private Contact contact;
    @OneToOne
    private CustomerAddress customerAddress;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="customer_id")
    private List<Order> orders;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="customer_id")
    private List<CreditCard> creditcards;
    
    private Customer(){}
    
    private Customer(Builder build){
        id=build.id;
        customerNumber=build.customerNumber;
        name=build.name;
        demographic=build.demographic;
        contact=build.contact;
        customerAddress=build.customerAddress;
        orders=build.orders;
        creditcards=build.creditcards;
    }
    
    public static class Builder{
        private Long id;
        private String customerNumber;
        private Name name;
        private Demographic demographic;
        private Contact contact;
        private CustomerAddress customerAddress;
        private List<Order> orders;
        private List<CreditCard> creditcards;
        
        public Builder(String custNum){
            this.customerNumber=custNum;
        } 
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder name(Name n){
            this.name=n;
            return this;
        }
        
        public Builder demographic(Demographic demo){
            this.demographic=demo;
            return this;
        }
        
        public Builder contact(Contact cont){
            this.contact=cont;
            return this;
        }
        
        public Builder customerAddress(CustomerAddress custaddress){
            this.customerAddress=custaddress;
            return this;
        }
        
        public Builder orders(List<Order> orde){
            this.orders=orde;
            return this;
        }
       
        public Builder creditcards(List<CreditCard> ccards){
            this.creditcards= ccards;
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public Name getName() {
        return name;
    }

    public Demographic getDemographic() {
        return demographic;
    }

  public Contact getContact() {
        return contact;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<CreditCard> getCreditcards() {
        return creditcards;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + '}';
    }
    
}
