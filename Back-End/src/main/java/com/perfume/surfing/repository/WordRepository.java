package com.perfume.surfing.repository;


import com.perfume.surfing.domain.Word;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WordRepository {

    private final EntityManager em;

    public void save(Word word) {
        em.persist(word);
    }

    public List<Word> findByAliasStartingWith(String alias) {
        return em.createQuery("SELECT w FROM Word w WHERE w.alias LIKE :alias", Word.class)
                .setParameter("alias", alias + "%")
                .getResultList();
    }
    // Update =============================================
    public Optional<Word> updateWord(Long wordId, String newAlias, String newName) {
        Word word = em.find(Word.class, wordId);
        if (word != null) {
            word.setAlias(newAlias);
            word.setName(newName);
            return Optional.of(word);
        }
        return Optional.empty();
    }
}
