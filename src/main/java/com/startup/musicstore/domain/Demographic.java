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
@Embeddable
public class Demographic implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gender;
    private String race;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    
    private Demographic(){}
    
    private Demographic(Builder build){
        id=build.id;
        gender=build.gender;
        race=build.race;
        dateOfBirth=build.dateOfBirth;
    }
  public static class Builder{
      private Long id;
        private String gender;
        private String race;
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date dateOfBirth;
        
        public Builder(Date dob){
            this.dateOfBirth=dob;
        }
        
        public Builder gender(String g){
            this.gender=g;
            return this;
        }
        
        public Builder race(String ra){
            this.race=ra;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Demographic build(){
            return new Demographic(this);
        }
  }

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Demographic other = (Demographic) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Demographic{" + "id=" + id + '}';
    }
  
}
