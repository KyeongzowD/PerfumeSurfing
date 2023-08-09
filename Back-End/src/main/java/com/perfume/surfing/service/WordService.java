package com.perfume.surfing.service;


import com.perfume.surfing.domain.Word;
import com.perfume.surfing.domain.WordType;
import com.perfume.surfing.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    @Transactional(readOnly = false)
    public Word saveWordWithMapping(String name, String alias, WordType type) {
        Word word = new Word(name, alias, type);
        wordRepository.save(word);
        return word;
    }

    public List<Word> getAutocompleteWords(String alias) {
        return wordRepository.findByAliasStartingWith(alias);
    }
}
