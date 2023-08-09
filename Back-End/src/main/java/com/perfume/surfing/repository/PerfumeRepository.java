package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Perfume;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PerfumeRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Perfume perfume) {
        em.persist(perfume);
    }

    // Read ===============================================
    public Optional<Perfume> findById(int id) {
        return Optional.ofNullable(em.find(Perfume.class, id));
    }

    public Optional<Perfume> findByName(String name){
        List<Perfume> result = em.createQuery("select m from Perfume m where m.name= :name", Perfume.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    public List<Perfume> findAll() {
        return em.createQuery("select b from Perfume b", Perfume.class)
                .getResultList();
    }

    public List<Perfume> findAllByWord(PerfumeSearch perfumeSearch){
        return new ArrayList<>();
    }

//    // Update =============================================
//    @Transactional
//    public Optional<Perfume> updatePerfume(int perfumeId, String newName, int newPrice, String newUrl) {
//        Perfume perfume = em.find(Perfume.class, perfumeId);
//        if (perfume != null) {
//            perfume.setName(newName);
//            perfume.setPrice(newPrice);
//            perfume.setUrl(newUrl);
//            return Optional.of(perfume);
//        }
//        return Optional.empty();
//    }
//
//
//
//
//    // Delete =============================================
}
