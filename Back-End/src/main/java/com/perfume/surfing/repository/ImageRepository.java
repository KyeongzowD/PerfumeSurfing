package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.domain.Image;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImageRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Image image) {
        em.persist(image);
    }

    // Read ===============================================
    public Optional<Image> findById(int id) {
        return Optional.ofNullable(em.find(Image.class, id));
    }


    public Optional<Image> findByName(String name){
        List<Image> result = em.createQuery("select m from Image m where m.name= :name", Image.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    public List<Image> findAll() {
        return em.createQuery("select b from Image b", Image.class)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
