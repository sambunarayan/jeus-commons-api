package jp.co.jeus.commons_api.voca.repository;

import jp.co.jeus.commons_api.commons.repository.VocabularyRepository;
import jp.co.jeus.commons_api.commons.repository.entity.Vocabulary;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VocabularyRepositoryTest {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    private Vocabulary vocabulary;

    @BeforeEach
    public void setUp() {
        vocabulary = new Vocabulary();
        vocabulary.setEn("Test1");
        vocabulary.setJp("テスト１");
        vocabulary.setKr("테스트1");
        vocabularyRepository.save(vocabulary);
    }

    @AfterEach
    public void tearDown() {
        vocabularyRepository.delete(vocabulary);
    }

    @Test
    public void testFindAll() {
        List<Vocabulary> actual =  vocabularyRepository.findAll();

        // then
        assertThat(actual.isEmpty()).isFalse();
    }
}
