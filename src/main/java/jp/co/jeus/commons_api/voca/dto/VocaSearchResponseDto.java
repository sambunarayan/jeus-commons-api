package jp.co.jeus.commons_api.voca.dto;

import jp.co.jeus.commons_api.commons.dto.ResponseCommonDto;
import lombok.Data;

import java.util.List;

@Data
public class VocaSearchResponseDto extends ResponseCommonDto {

    private List<VocabularyDto> results;
}
