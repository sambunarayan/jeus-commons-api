package jp.co.jeus.commons_api.voca.rest.controller;

import jp.co.jeus.commons_api.commons.dto.VocabularyRegistrationDto;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("voca")
@RestController
public class VocaDataRestController {

    @Autowired
    private VocabularyService vocabularyService;

    @GetMapping("find-all")
    public VocaSearchResponseDto findAllVocabulary() {
        return vocabularyService.findAll();
    }

    @PostMapping("add")
    public void add(@RequestBody VocabularyRegistrationDto registrationDto) {
        vocabularyService.registerVocabulary(registrationDto);
    }
}
