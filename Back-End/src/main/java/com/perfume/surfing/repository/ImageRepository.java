package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Image;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Image image) {
        em.persist(image);
    }

    // Read ===============================================
    public Image findOne(int id) {
        return em.find(Image.class, id);
    }

    public List<Image> findAll() {
        return em.createQuery("select b from Image b", Image.class)
                .getResultList();
    }

    public List<Image> findByName(String name){
        return em.createQuery("select m from Image m where m.name = :name", Image.class)
                .setParameter("name", name)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
