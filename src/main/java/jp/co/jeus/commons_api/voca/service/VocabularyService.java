package jp.co.jeus.commons_api.voca.service;

import jp.co.jeus.commons_api.commons.repository.VocabularyRepository;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.dto.VocabularyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VocabularyService {

    @Autowired
    private VocabularyRepository vocabularyRepository;

    public VocaSearchResponseDto findAll() {
        List<VocabularyDto> vocalbularies = vocabularyRepository.findAll()
                .stream()
                .map(e -> new VocabularyDto(e.getEn(), e.getJp(), e.getKr()))
                .collect(Collectors.toList());
        return new VocaSearchResponseDto(vocalbularies);
    }
}
