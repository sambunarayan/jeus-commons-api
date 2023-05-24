package jp.co.jeus.commons_api.voca.service;

import jp.co.jeus.commons_api.commons.dto.VocabularyRegistrationDto;
import jp.co.jeus.commons_api.commons.repository.VocabularyRepository;
import jp.co.jeus.commons_api.commons.repository.entity.Vocabulary;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.dto.VocabularyDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class VocabularyServiceTest {

    @InjectMocks
    private VocabularyService vocabularyService;
    @Mock
    private VocabularyRepository vocabularyRepository;

    @Test
    public void testNoResult() {
        // when
        when(vocabularyRepository.findAll()).thenReturn(Collections.emptyList());
        VocaSearchResponseDto responseDto = vocabularyService.findAll();

        // then
        assertThat(responseDto.getResults().isEmpty()).isTrue();
    }

    @Test
    public void testSingleResult() {
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

    @Test
    public void testMultiResult() {
        // when
        Vocabulary voca1 = new Vocabulary(1,"test","テスト","테스트");
        Vocabulary voca2 = new Vocabulary(1,"test","テスト","테스트");
        when(vocabularyRepository.findAll()).thenReturn(List.of(voca1, voca2));
        VocaSearchResponseDto responseDto = vocabularyService.findAll();

        // then
        assertThat(responseDto.getResults().size()).isEqualTo(2);
        VocabularyDto actual = responseDto.getResults().get(0);
        assertThat(actual.getEn()).isEqualTo(voca1.getEn());
        assertThat(actual.getJp()).isEqualTo(voca1.getJp());
        assertThat(actual.getKr()).isEqualTo(voca1.getKr());

        actual = responseDto.getResults().get(1);
        assertThat(actual.getEn()).isEqualTo(voca2.getEn());
        assertThat(actual.getJp()).isEqualTo(voca2.getJp());
        assertThat(actual.getKr()).isEqualTo(voca2.getKr());
    }

    @Test
    public void testRegisterVocabulary() {
        VocabularyRegistrationDto requestDto = new VocabularyRegistrationDto();
        requestDto.setEn("test");
        requestDto.setJp("テスト");
        requestDto.setKr("테스트");

        // when
        vocabularyService.registerVocabulary(requestDto);

        // then
        verify(vocabularyRepository, times(1)).save(any());
    }
}
