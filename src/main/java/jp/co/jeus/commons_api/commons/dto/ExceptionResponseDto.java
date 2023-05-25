package jp.co.jeus.commons_api.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponseDto {

    private int code;
    private String name;
    private String details;
}
