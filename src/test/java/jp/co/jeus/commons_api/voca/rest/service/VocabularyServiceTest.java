package jp.co.jeus.commons_api.voca.rest.service;

import jp.co.jeus.commons_api.commons.repository.VocabularyRepository;
import jp.co.jeus.commons_api.commons.repository.entity.Vocabulary;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.dto.VocabularyDto;
import jp.co.jeus.commons_api.voca.service.VocabularyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VocabularyServiceTest {

    @InjectMocks
    private VocabularyService vocabularyService;
    @Mock
    private VocabularyRepository vocabularyRepository;

    @Test
    public void test() {
        // when
        Vocabulary voca = new Vocabulary(1,"test","テスト","테스트");
        when(vocabularyRepository.findAll()).thenReturn(List.of(voca));
        VocaSearchResponseDto responseDto = vocabularyService.findAll();

        // then
        assertThat(responseDto.getResults().isEmpty()).isFalse();
        VocabularyDto actual = responseDto.getResults().get(0);
        assertThat(actual.getEn()).isEqualTo(voca.getEn());
        assertThat(actual.getJp()).isEqualTo(voca.getJp());
        assertThat(actual.getKr()).isEqualTo(voca.getKr());
    }
}
