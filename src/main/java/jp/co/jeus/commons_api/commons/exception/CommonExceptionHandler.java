package jp.co.jeus.commons_api.commons.exception;

import jp.co.jeus.commons_api.commons.constants.Result;
import jp.co.jeus.commons_api.commons.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseDto handleUnexpectedException(Exception e) {
        return new ExceptionResponseDto(Result.INTERNAL_SERVER_ERROR.getCode(),
                Result.INTERNAL_SERVER_ERROR.getCodeName(),
                Result.INTERNAL_SERVER_ERROR.getDetails());
    }
}
