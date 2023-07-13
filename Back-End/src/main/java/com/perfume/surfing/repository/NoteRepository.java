package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Note;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoteRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Note note) {
        em.persist(note);
    }

    // Read ===============================================
    public Note findOne(int id) {
        return em.find(Note.class, id);
    }

    public List<Note> findAll() {
        return em.createQuery("select b from Note b", Note.class)
                .getResultList();
    }

    public List<Note> findByName(String name){
        return em.createQuery("select m from Note m where m.name = :name", Note.class)
                .setParameter("name", name)
                .getResultList();
    }

    // Update =============================================


    // Delete =============================================
}
