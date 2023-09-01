package jp.co.jeus.commons_api.redis.controller;

import jp.co.jeus.commons_api.redis.dto.SessionDto;
import jp.co.jeus.commons_api.redis.dto.SessionRegistDto;
import jp.co.jeus.commons_api.redis.dto.SessionRegistResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("session")
public class SessionController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("regist")
    public SessionRegistResultDto regist(@RequestBody SessionRegistDto registDto) {
        SessionRegistResultDto resultDto = new SessionRegistResultDto();
        if (registDto.getId() != null) {
            redisTemplate.delete(registDto.getId());
            resultDto.setSessionId(registDto.getId());
        } else {
            resultDto.setSessionId(UUID.randomUUID().toString());
        }
        redisTemplate.opsForValue().set(resultDto.getSessionId(), registDto.getMap());
        redisTemplate.expire(resultDto.getSessionId(), Duration.ofMinutes(2));
        return resultDto;
    }

    @GetMapping("get")
    private SessionDto get(@RequestParam("id") String sessionId) {
        SessionDto session = new SessionDto();
        session.setMap((Map<String, String>)redisTemplate.opsForValue().get(sessionId));
        return session;
    }

    @DeleteMapping("delete")
    private void delete(@RequestParam("id") String sessionId) {

    }
}
