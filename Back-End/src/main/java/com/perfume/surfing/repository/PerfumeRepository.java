package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Perfume;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PerfumeRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Perfume perfume) {
        em.persist(perfume);
    }

    // Read ===============================================
    public Perfume findOne(int id) {
        return em.find(Perfume.class, id);
    }

    public List<Perfume> findAll() {
        return em.createQuery("select b from Perfume b", Perfume.class)
                .getResultList();
    }

    public List<Perfume> findByName(String name){
        return em.createQuery("select m from Perfume m where m.name = :name", Perfume.class)
                .setParameter("name", name)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
