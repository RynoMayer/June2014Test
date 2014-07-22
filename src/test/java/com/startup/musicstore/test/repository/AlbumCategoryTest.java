/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.AlbumCategory;

import com.startup.musicstore.respository.AlbumCategoryRepo;
import com.startup.musicstore.test.ConnectionConfigTest;

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
public class AlbumCategoryTest {
     public static ApplicationContext ctx;
    private Long id;
    private AlbumCategoryRepo albumCategoryRepo;
    public AlbumCategoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
     public void createAlbumCategory() {
         albumCategoryRepo = ctx.getBean(AlbumCategoryRepo.class);
         AlbumCategory albumcat1=new AlbumCategory.Builder("punk")
                 
                 .build();
         
         albumCategoryRepo.save(albumcat1);
         id=albumcat1.getId();
         Assert.assertNotNull(albumcat1);
         
     }
     
     @Test(dependsOnMethods = "createAlbumCategory", enabled = true)
    public void readAlbumCategory() {
        albumCategoryRepo = ctx.getBean(AlbumCategoryRepo.class);
        AlbumCategory album1 = albumCategoryRepo.findOne(id);
        Assert.assertEquals(album1.getCategoryName(), "punk");

    }

    @Test(dependsOnMethods = "readAlbumCategory", enabled = true)
    private void updateAlbumCategory() {
        albumCategoryRepo = ctx.getBean(AlbumCategoryRepo.class);
        //GET THE OBJECT 
        AlbumCategory album1 = albumCategoryRepo.findOne(id);
        //CREATAE A NEW COPY 
        AlbumCategory updatedAlbumCategory = new AlbumCategory.Builder("Rock")
                
                
                .build();

        //SAVE THE NEW COPY
        albumCategoryRepo.save(updatedAlbumCategory);
        // GET NEW CARD AND TEST 
        AlbumCategory newAlbumCategory = albumCategoryRepo.findOne(id);
        Assert.assertEquals(newAlbumCategory.getCategoryName(), "Rock");

    }

    @Test(dependsOnMethods = "updateAlbumCategory", enabled = true)
    private void deleteAlbumCategory() {

        albumCategoryRepo = ctx.getBean(AlbumCategoryRepo.class);
        //GET OBJECT 
        AlbumCategory person = albumCategoryRepo.findOne(id);
        //DELETE OBJECT 
        albumCategoryRepo.delete(person);
        // TRY GETTING THE OBJECT 
        AlbumCategory deletedAlbumCategory = albumCategoryRepo.findOne(id);
        // CHECK IF YOU GOT NOTHING 
        Assert.assertNull(deletedAlbumCategory);

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
