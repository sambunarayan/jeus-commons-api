package jp.co.jeus.commons_api.redis.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Setter
@Getter
public class SessionDto {

    private Map<String, String> map;
}
