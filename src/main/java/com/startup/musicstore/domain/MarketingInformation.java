/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class MarketingInformation implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="marketingInformation_id")
    private List<Review> reviews;
    
    @OneToOne
    private ArtistInformation artistInfo;
    
    private String statusOfInformation;
    
    private MarketingInformation(){}
    
    private MarketingInformation(Builder build){
        id=build.id;
        reviews=build.reviews;
        artistInfo=build.artistInfo;
        statusOfInformation=build.statusOfInformation;
    }
    
    public static class Builder{
        private Long id;
        private ArtistInformation artistInfo;
        private String statusOfInformation;
        private List<Review> reviews;
        
        public Builder(String soi){
            this.statusOfInformation=soi;
        }
        
        public Builder ArtistInfo(ArtistInformation ai){
            this.artistInfo=ai;
            return this;
        }
        
        public Builder Reviews(List<Review> rev){
            this.reviews=rev;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        
        
    }

    public Long getId() {
        return id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public ArtistInformation getArtistInfo() {
        return artistInfo;
    }

    public String getStatusOfInformation() {
        return statusOfInformation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final MarketingInformation other = (MarketingInformation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MarketingInformation{" + "id=" + id + '}';
    }
    
    
}
