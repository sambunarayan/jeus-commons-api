package jp.co.jeus.commons_api.voca.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("voca")
@RestController
public class VocaDataRestController {

    @GetMapping("find-all")
    public void findAllVocabulary() {


    }
}