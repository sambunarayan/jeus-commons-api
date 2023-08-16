package jp.co.jeus.commons_api.redis.controller;

import jp.co.jeus.commons_api.redis.dto.RedisSampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping(value = "/SampleRedis")
public class RedisSampleController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping
    public void post(@RequestBody RedisSampleData redisSampleData) {
        redisTemplate.delete("redis-tutorial:string");
        redisTemplate.opsForValue()
                .set("redis-tutorial:string", redisSampleData.getString());
        redisTemplate.expire("redis-tutorial:string", Duration.ofSeconds(60));
        redisTemplate.delete("redis-tutorial:list");
        redisTemplate.opsForList()
                .rightPushAll("redis-tutorial:list",
                        redisSampleData.getList().toArray(new String[0]));
        redisTemplate.expire("redis-tutorial:list", Duration.ofSeconds(60));
        redisTemplate.delete("redis-tutorial:map");
        redisTemplate.opsForHash()
                .putAll("redis-tutorial:map", redisSampleData.getMap());
        redisTemplate.expire("redis-tutorial:map", Duration.ofSeconds(60));
    }

    @GetMapping
    public RedisSampleData get() {
        RedisSampleData redisSampleData = new RedisSampleData();
        redisSampleData.setString(
                redisTemplate.opsForValue()
                        .get("redis-tutorial:string")
        );
        redisSampleData.setList(
                redisTemplate.opsForList()
                        .range("redis-tutorial:list", 0, -1)
        );
        redisSampleData.setMap(
                redisTemplate.<String, String>opsForHash()
                        .entries("redis-tutorial:map")
        );
        return redisSampleData;
    }
}
