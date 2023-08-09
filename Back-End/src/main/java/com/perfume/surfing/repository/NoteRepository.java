package com.perfume.surfing.repository;

import com.perfume.surfing.domain.Image;
import com.perfume.surfing.domain.Note;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NoteRepository {

    private final EntityManager em;

    // Create =============================================
    public void save(Note note) {
        em.persist(note);
    }

    // Read ===============================================
    public Optional<Note> findById(int id) {
        return Optional.ofNullable(em.find(Note.class, id));
    }

    public Optional<Note> findByName(String name) {
        List<Note> result = em.createQuery("select m from Note m where m.name= :name", Note.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    public List<Note> findAll() {
        return em.createQuery("select b from Note b", Note.class)
                .getResultList();
    }

//    // Update =============================================
//    @Transactional
//    public Optional<Note> updateNote(int noteId, String newName, Image newImage) {
//        Note note = em.find(Note.class, noteId);
//        if (note != null) {
//            note.setName(newName);
////            note.setImage_id(newImage); // 이미지를 새로운 값으로 갱신
//            return Optional.of(note);
//        }
//        return Optional.empty();
//
//
//        // Delete =============================================
//    }
}
