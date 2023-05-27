package jp.co.jeus.commons_api.voca.rest.controller;

import com.google.gson.Gson;
import jp.co.jeus.commons_api.commons.dto.VocabularyRegistrationDto;
import jp.co.jeus.commons_api.voca.service.VocabularyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VocaDataRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VocabularyService vocabularyService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testfindAll() throws Exception {
        // when
        mvc.perform(get("/voca/find-all")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        // then
        verify(vocabularyService, times(1)).findAll();
    }

    @Test
    public void testAdd() throws Exception {
        VocabularyRegistrationDto requestDto = new VocabularyRegistrationDto();
        requestDto.setEn("test");
        requestDto.setJp("テスト");
        requestDto.setKr("테스트");

        // when
        mvc.perform(post("/voca/add")
                        .contentType("application/json")
                        .content(new Gson().toJson(requestDto)))
                .andExpect(status().isOk());

        // then
        verify(vocabularyService, times(1)).registerVocabulary(any());
    }
}
