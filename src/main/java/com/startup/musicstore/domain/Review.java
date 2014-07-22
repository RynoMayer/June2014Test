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
public class Review implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int rating;
    
    private Review(){}
    
    private Review(Builder build){
        id=build.id;
        description=build.description;
        rating = build.rating;
    }
    
    public static class Builder{
        private Long id;
        private String description;
        private int rating;
        
        public Builder(int ra){
            this.rating=ra;
        }
        
        public Builder Description(String des){
            this.description=des;
            return this;
        }
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        public Builder ratings (int ra){
            this.rating=ra;
            return this;
        }
        
        public Review Build(){
            return new Review(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Review other = (Review) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + '}';
    }
    
}
