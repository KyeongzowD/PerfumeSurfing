package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Word;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WordRepository {

    private final EntityManager em;

    public Word save(Word word) {
        if (word.getId() == null) {
            em.persist(word);
            return word;
        } else {
            return em.merge(word);
        }
    }

    public List<Word> findByAliasStartingWith(String alias) {
        return em.createQuery("SELECT w FROM Word w WHERE w.alias LIKE :alias", Word.class)
                .setParameter("alias", alias + "%")
                .getResultList();
    }
}
