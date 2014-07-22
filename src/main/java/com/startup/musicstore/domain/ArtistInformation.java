/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class ArtistInformation implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    private ArtistInformation(){}
    
    private ArtistInformation(Builder build){
        id=build.id;
        firstName= build.firstName;
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
        
        public ArtistInformation build(){
            return new ArtistInformation(this);
        }
    }
}
