package jp.co.jeus.commons_api.voca.rest.controller;

import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.service.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void add() {

    }
}
