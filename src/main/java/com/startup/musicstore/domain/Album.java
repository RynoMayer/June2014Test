/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
/**
 *
 * @author 212017705
 */
@Entity
public class Album implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private MarketingInformation marketinfo;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="Album_id")
    private List<Track> tracks;
    
    private String albumTitle;
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    
    private Album(){}
    
    private Album(Builder build){
        id=build.id;
        marketinfo=build.marketinfo;
        tracks=build.tracks;
        albumTitle=build.albumTitle;
        unitPrice=build.unitPrice;
        inventory=build.inventory;
        sales=build.sales;
    }
    
    public static class Builder{
        private String albumTitle;
        private BigDecimal unitPrice;
        private int inventory;
        private int sales;
        private Long id;
        private List<Track> tracks;
        private MarketingInformation marketinfo;
        
        public Builder(String albumTitle){
            this.albumTitle=albumTitle;
        }
        
        public Builder unitPrice(BigDecimal up){
            this.unitPrice=up;
            return this;
        }
        
        public Builder inventory(int invent){
            this.inventory=invent;
            return this;
        }
        
        public Builder sales(int sales){
            this.sales=sales;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder tracks(List<Track> tracks){
            this.tracks=tracks;
            return this;
        }
        
        public Builder marketingInformation(MarketingInformation mInfo){
            this.marketinfo=mInfo;
            return this;
        }
        
        public Builder Album(Album a){
            id=a.getId();
            marketinfo=a.getMarketinfo();
            tracks=a.getTracks();
            albumTitle=a.getAlbumTitle();
            unitPrice=a.getUnitPrice();
            inventory=a.getInventory();
            sales=a.getSales();
            return this;
        }
        
        public Album build(){
            return new Album(this);
        }
    }

    public Long getId() {
        return id;
    }

    public MarketingInformation getMarketinfo() {
        return marketinfo;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Album other = (Album) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + '}';
    }
    
    
}
