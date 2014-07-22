/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Album;
import java.util.List;

/**
 *
 * @author 212017705
 */
public interface AlbumGenderSalesService extends Services <Album, Long>{
    public List<Album> getSalesGender(String gender);
}
