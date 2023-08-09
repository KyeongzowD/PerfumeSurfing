package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.repository.BrandRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class BrandRepositoryTest {

    @Autowired private BrandRepository brandRepository;
    @Autowired private EntityManager em;



//    @Test
//    public void testUpdateBrand() {
//        // Given
//        Brand brand = new Brand();
//        brand.setName("kjw");
//        brand.setUrl("https://www.kjw.com");
//        brandRepository.save(brand);
//
//        int brandId = brand.getId();
//        String newName = "kjwkjwkj";
//        String newUrl = "https://www.sdfasfasd.com";
//
//        // When
//        Optional<Brand> updatedBrand = brandRepository.updateBrand(brandId, newName, newUrl);
//
//        // Then
//        assertTrue(updatedBrand.isPresent());
//        assertEquals(newName, updatedBrand.get().getName());
//        assertEquals(newUrl, updatedBrand.get().getUrl());
//
//
//        Optional<Brand> foundBrand = brandRepository.findById(brandId);
//        assertTrue(foundBrand.isPresent());
//        assertEquals(newName, foundBrand.get().getName());
//        assertEquals(newUrl, foundBrand.get().getUrl());
//    }
}
