package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Brand;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Brand brand) {
        em.persist(brand);
    }

    // Read ===============================================
    public Brand findById(Long id) {
        return em.find(Brand.class, id);
    }

    public Optional<Brand> findByName(String name){
        List<Brand> result = em.createQuery("select m from Brand m where m.name= :name", Brand.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    public List<Brand> findAll() {
        return em.createQuery("select b from Brand b", Brand.class)
                .getResultList();
    }

//    // Update =============================================
//    @Transactional
//    public Optional<Brand> updateBrand(int brandId, String newName, String newUrl) {
//        Brand brand = em.find(Brand.class, brandId);
//        if (brand != null) {
//            brand.setName(newName);
//            brand.setUrl(newUrl);
//            return Optional.of(brand);
//        }
//        return Optional.empty();
//    }
//
//
//
//    // Delete =============================================
}
