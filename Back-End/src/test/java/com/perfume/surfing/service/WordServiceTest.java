package com.perfume.surfing.service;

import com.perfume.surfing.domain.WordType;
import com.perfume.surfing.domain.Word;
import com.perfume.surfing.repository.WordRepository;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WordServiceTest {

    @Autowired private WordRepository wordRepository;

    @Autowired private WordService wordService;

    @Autowired EntityManager em;

    @Test
    public void 저장() {
        // 테스트용 데이터
        String name = "TestWord";
        String alias = "test";
        WordType type = WordType.BRAND;

        // 서비스 메서드 호출
        Word savedWord = wordService.saveWordWithMapping(name, alias, type);

        // 결과 확인
        em.flush();
        assertNotNull(savedWord.getId()); // 저장된 엔티티의 ID가 null이 아닌지 확인
        assertEquals(name, savedWord.getName()); // 저장된 엔티티의 이름이 올바른지 확인
        assertEquals(alias, savedWord.getAlias()); // 저장된 엔티티의 alias가 올바른지 확인
        assertEquals(type, savedWord.getType()); // 저장된 엔티티의 type이 올바른지 확인
    }

    @Test
    public void 자동완성_반환_에러() {

        // 테스트용 데이터
        String alias = "test";

        // 서비스 메서드 호출
        List<Word> result = wordService.getAutocompleteWords(alias);

        // 결과 확인
        assertNotNull(result); // 결과가 null이 아닌지 확인
        assertFalse(result.isEmpty());

    }
}
