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
@Entity
public class Track implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int trackNumber;
    private String trackTitle;
    @OneToOne
    private SampleClip sample;
    
    private Track(){}
    
    private Track(Builder build){
        id=build.id;
        trackNumber=build.trackNumber;
        trackTitle=build.trackTitle;
        sample=build.sample;
    }
    
    public static class Builder{
        private Long id;
        private int trackNumber;
        private String trackTitle;
        private SampleClip sample;
        
        public Builder(int tnum){
            this.trackNumber=tnum;
        }
        
        public Builder trackTitle(String ttitle){
            this.trackTitle=ttitle;
            return this;
        }
        
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        
        public Builder sampleClip(SampleClip surl){
            this.sample=surl;
            return this;
        }
        public Track build(){
            return new Track(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Track other = (Track) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Track{" + "id=" + id + '}';
    }
    
}
