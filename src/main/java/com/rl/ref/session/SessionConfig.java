package com.rl.ref.session;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableCaching
public class SessionConfig {

  /*  @Bean
    public JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }*/
}

