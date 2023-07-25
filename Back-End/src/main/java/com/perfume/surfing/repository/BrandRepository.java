package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Brand;
import jakarta.persistence.EntityManager;
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
    public Optional <Brand> findById(int id) {
        return Optional.ofNullable(em.find(Brand.class, id));
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

    // Update =============================================


    // Delete =============================================
}
