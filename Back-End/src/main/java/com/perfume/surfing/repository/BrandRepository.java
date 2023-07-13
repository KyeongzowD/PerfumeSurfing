package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Brand;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BrandRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Brand brand) {
        em.persist(brand);
    }

    // Read ===============================================
    public Brand findOne(int id) {
        return em.find(Brand.class, id);
    }

    public List<Brand> findAll() {
        return em.createQuery("select b from Brand b", Brand.class)
                .getResultList();
    }

    public List<Brand> findByName(String name){
        return em.createQuery("select m from Brand m where m.name = :name", Brand.class)
                .setParameter("name", name)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
