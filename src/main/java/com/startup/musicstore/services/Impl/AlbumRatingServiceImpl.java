/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.respository.AlbumRepo;
import com.startup.musicstore.services.AlbumRatingsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 212017705
 */
@Service
public class AlbumRatingServiceImpl implements AlbumRatingsService{
    @Autowired
    private AlbumRepo albumRepo;
    
    
    @Override
    public Album find(Long id) {
        return albumRepo.findOne(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album persist(Album entity) {
        return albumRepo.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album merge(Album entity) {
        if (entity.getId() != null) {
            return albumRepo.save(entity);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Album entity) {
        albumRepo.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Album> findAll() {
        return albumRepo.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAlbumRatings(String title) {
        Album album1 = null;
        List<Album> albums = findAll();
        for (Album album : albums) {
            if (title.equalsIgnoreCase(album.getAlbumTitle())) {
                album1 = album;
            }
        }
        return album1.getMarketinfo().getReviews().getRating();
    }
   
}
