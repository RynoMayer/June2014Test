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
import org.hibernate.engine.internal.Cascade;

/**
 *
 * @author 212017705
 */
@Entity
public class AlbumCategory implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="albumCategory_id")
    private List <Album> albums;
    
    private AlbumCategory(){}
    
    private AlbumCategory(Builder build){
        id=build.id;
        categoryName=build.categoryName;
        albums=build.albums;
        
    }
    
    public static class Builder{
        private Long id;
        private String categoryName;
        private List <Album> albums;
        
        public Builder(String catname){
            this.categoryName=catname;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder Albums(List<Album> als){
            this.albums=als;
            return this;
        }
        
        public AlbumCategory build(){
            return new AlbumCategory(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Album> getAlbums() {
        return albums;
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
        final AlbumCategory other = (AlbumCategory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AlbumCategory{" + "id=" + id + '}';
    }
           
}
