package com.perfume.surfing.repository;

import com.perfume.surfing.domain.PerfumeNote;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PerfumeNoteRepository {
    private final EntityManager em;

    // Create =============================================
    public void save(PerfumeNote perfume) {
        em.persist(perfume);
    }

    // Read ===============================================
    public PerfumeNote findOne(int id) {
        return em.find(PerfumeNote.class, id);
    }

    public List<PerfumeNote> findAll() {
        return em.createQuery("select b from PerfumeNote b", PerfumeNote.class)
                .getResultList();
    }

    public List<PerfumeNote> findByPerfumeId(int id){
        return em.createQuery("select m from PerfumeNote m where m.perfume = :id", PerfumeNote.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<PerfumeNote> findByNoteId(int id){
        return em.createQuery("select m from PerfumeNote m where m.note = :id", PerfumeNote.class)
                .setParameter("id", id)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
