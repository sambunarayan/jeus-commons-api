package jp.co.jeus.commons_api.redis.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public class RedisSampleData {
    private String string;

    private List<String> list;

    private Map<String, String> map;
}
