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
public class SampleClip implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sampleURL;
    
    private SampleClip(){}
    
    private SampleClip(Builder build){
        id=build.id;
        sampleURL=build.sampleURL;
    }
    
    public static class Builder{
        private Long id;
        private String sampleURL;
        
        public Builder(String surl){
            this.sampleURL=surl;
        }
        public Builder Id(Long i){
            this.id=i;
            return this;
        }
        public SampleClip build(){
            return new SampleClip(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSampleURL() {
        return sampleURL;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final SampleClip other = (SampleClip) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SampleClip{" + "id=" + id + '}';
    }
    
}
