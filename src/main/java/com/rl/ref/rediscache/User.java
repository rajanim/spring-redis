package com.rl.ref.rediscache;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("user")
public class User {
    private String id;
    private String name;
    private String status;
}
