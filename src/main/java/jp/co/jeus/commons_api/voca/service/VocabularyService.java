package jp.co.jeus.commons_api.voca.service;

import jp.co.jeus.commons_api.commons.constants.Result;
import jp.co.jeus.commons_api.commons.dto.VocabularyRegistrationDto;
import jp.co.jeus.commons_api.commons.repository.VocabularyRepository;
import jp.co.jeus.commons_api.commons.repository.entity.Vocabulary;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.dto.VocabularyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VocabularyService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    /**
     *
     * @return
     */
    public VocaSearchResponseDto findAll() {
        List<VocabularyDto> vocalbularies = vocabularyRepository.findAll()
                .stream()
                .map(e -> new VocabularyDto(e.getEn(), e.getJp(), e.getKr()))
                .toList();
        return new VocaSearchResponseDto(Result.SUCCESS, vocalbularies);
    }

    /**
     *
     * @param registrationDto
     */
    public void registerVocabulary(VocabularyRegistrationDto registrationDto) {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setEn(registrationDto.getEn());
        vocabulary.setJp(registrationDto.getJp());
        vocabulary.setKr(registrationDto.getKr());
        vocabularyRepository.save(vocabulary);
    }
}
