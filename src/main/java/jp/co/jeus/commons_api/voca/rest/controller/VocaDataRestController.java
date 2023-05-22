package jp.co.jeus.commons_api.voca.rest.controller;

import jp.co.jeus.commons_api.commons.constants.Result;
import jp.co.jeus.commons_api.commons.dto.VocabularyRegistrationDto;
import jp.co.jeus.commons_api.voca.dto.VocaRegistrationResponseDto;
import jp.co.jeus.commons_api.voca.dto.VocaSearchResponseDto;
import jp.co.jeus.commons_api.voca.service.VocabularyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("voca")
@RestController
public class VocaDataRestController {

    private Logger logger = LogManager.getLogger(VocaDataRestController.class);

    @Autowired
    private VocabularyService vocabularyService;

    @GetMapping("find-all")
    public VocaSearchResponseDto findAllVocabulary() {
        logger.info("find all");
        return vocabularyService.findAll();
    }

    @PostMapping("add")
    public VocaRegistrationResponseDto add(@RequestBody VocabularyRegistrationDto registrationDto) {
        logger.info("add vocabulary");
        vocabularyService.registerVocabulary(registrationDto);
        return new VocaRegistrationResponseDto(Result.SUCCESS);
    }
}
