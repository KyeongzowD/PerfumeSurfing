package com.perfume.surfing.service;


import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.repository.BrandRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BrandServiceTest {

    @Autowired BrandService brandService;
    @Autowired BrandRepository brandRepository;
    @Autowired EntityManager em;

    @Test
    public void 브랜드추가() throws Exception{
        //given
        Brand brand = new Brand();
        brand.setName("딥디크");
        brand.setUrl("https://www.sivillage.com/dispctg/initBrandCtg.siv?disp_ctg_no=010000039942");
        brand.setCreated_at(sqlDate());

        //when
        Long saveId = brandService.add(brand);
        System.out.println("savedId: " + saveId);

        //then
        em.flush();
        assertEquals(brand, brandRepository.findById(saveId));
    }

    public java.sql.Date sqlDate(){
        Date utilDate = new Date();
        long milliSeconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(milliSeconds);

        return sqlDate;
    }

}
