/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.respository;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 212017705
 */
public interface ContactRepo extends JpaRepository<Contact, Long>{
    
}
