/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.respository.AlbumRepo;
import com.startup.musicstore.test.ConnectionConfigTest;
import static com.startup.musicstore.test.repository.AlbumRepoTest.ctx;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212017705
 */
public class AlbumRepoTest {
    public static ApplicationContext ctx;
    private Long id;
    private AlbumRepo albumRepo;
    public AlbumRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void createAlbum() {
         albumRepo = ctx.getBean(AlbumRepo.class);
         Album album1=new Album.Builder("Love")
                 .inventory(5)
                 .sales(2)
                 .unitPrice(new BigDecimal(50.000))
                 .build();
         
         albumRepo.save(album1);
         id=album1.getId();
         Assert.assertNotNull(album1);
         
     }
     
     @Test(dependsOnMethods = "createAlbum", enabled = true)
    public void readAlbum() {
        albumRepo = ctx.getBean(AlbumRepo.class);
        Album album1 = albumRepo.findOne(id);
        Assert.assertEquals(album1.getAlbumTitle(), "Love");

    }

    @Test(dependsOnMethods = "readAlbum", enabled = true)
    private void updateAlbum() {
        albumRepo = ctx.getBean(AlbumRepo.class);
        //GET THE OBJECT 
        Album album1 = albumRepo.findOne(id);
        //CREATAE A NEW COPY 
        Album updatedAlbum = new Album.Builder("Rock")
                .Album(album1)
                .unitPrice(new BigDecimal(150.00))
                .build();

        //SAVE THE NEW COPY
        albumRepo.save(updatedAlbum);
        // GET NEW CARD AND TEST 
        Album newAlbum = albumRepo.findOne(id);
        Assert.assertEquals(newAlbum.getAlbumTitle(), "Rock");

    }

    @Test(dependsOnMethods = "updateAlbum", enabled = true)
    private void deleteAlbum() {

        albumRepo = ctx.getBean(AlbumRepo.class);
        //GET OBJECT 
        Album person = albumRepo.findOne(id);
        //DELETE OBJECT 
        albumRepo.delete(person);
        // TRY GETTING THE OBJECT 
        Album deletedAlbum = albumRepo.findOne(id);
        // CHECK IF YOU GOT NOTHING 
        Assert.assertNull(deletedAlbum);

    }
   
    

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
