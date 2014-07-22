/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.respository.AlbumRepo;
import com.startup.musicstore.services.AlbumTrackUrlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 212017705
 */
public class AlbumTrackUrlServiceImpl implements AlbumTrackUrlService{
    @Autowired
    private AlbumRepo albumRepo;
        
    @Override
    public String getTrackURL(int trackNum) {
        Album album1 = null;
         List<Album> Albums = findAll();
         for (Album Album : Albums) {
            if (trackNum.equalsIgnoreCase(Album.getTracks().getTrackNumber())) 
            {
                album1 = Album;
            }
        }
        return album1.getTracks().getSampleURL();
    }

    @Override
    public Album find(Long id) {
        return albumRepo.findOne(id);
        
    }

    @Override
    public Album persist(Album entity) {
        return albumRepo.save(entity);
    }

    @Override
    public Album merge(Album entity) {
        if(entity.getId()!= null){
            return albumRepo.save(entity);
        }
        
        return null;
    }

    @Override
    public void remove(Album entity) {
       albumRepo.delete(entity);
    }

    @Override
    public List<Album> findAll() {
       return albumRepo.findAll();
    
    }
    
}
