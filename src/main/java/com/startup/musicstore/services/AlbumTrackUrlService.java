/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Album;

/**
 *
 * @author 212017705
 */
public interface AlbumTrackUrlService extends Services<Album, Long>{
    public String getTrackURL(int trackNum);
    
}
