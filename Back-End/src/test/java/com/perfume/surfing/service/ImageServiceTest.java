//package com.perfume.surfing.service;
//
//import com.perfume.surfing.domain.Image;
//import com.perfume.surfing.repository.ImageRepository;
//import jakarta.persistence.EntityManager;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.*;
//import java.util.Date;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class ImageServiceTest {
//
//    @Autowired ImageService imageService;
//    @Autowired ImageRepository imageRepository;
//    @Autowired EntityManager em;
//
//    @Test
//    public void 이미지추가() throws Exception{
//        //given
//        Image image = new Image();
//        image.setName("테스트");
//        image.setPath("어딘가/있겠지/아마도/제발");
//        image.setCreated_at(sqlDate());
//
//        //when
//        int saveId = imageService.add(image);
//        System.out.println("saveId: " + saveId);
//
//        //then
//        em.flush();
//        assertEquals(image, imageRepository.findById(saveId));
//    }
//
//    public java.sql.Date sqlDate(){
//        Date utilDate = new Date();
//        long milliSeconds = utilDate.getTime();
//        java.sql.Date sqlDate = new java.sql.Date(milliSeconds);
//
//        return sqlDate;
//    }
//}
