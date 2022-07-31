package cn.shorturl.store.template;

import cn.shorturl.core.ShortUrl;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 18:03
 */
public class ShortUrlRedisTemplate extends DefaultRedisTemplate<String, ShortUrl> {

    public ShortUrlRedisTemplate() {
        super(String.class, ShortUrl.class);
    }

    public ShortUrlRedisTemplate(RedisConnectionFactory connectionFactory) {
        this();
        this.setConnectionFactory(connectionFactory);
        this.afterPropertiesSet();
    }

//    public ShortUrlRedisTemplate() {
//        this.setKeySerializer(RedisSerializer.string());
//        this.setHashKeySerializer(RedisSerializer.string());
//        this.setValueSerializer(new Jackson2JsonRedisSerializer<>(ShortUrl.class));
//        this.setHashValueSerializer(RedisSerializer.string());
//    }
//
//    public ShortUrlRedisTemplate(RedisConnectionFactory connectionFactory) {
//        this();
//        this.setConnectionFactory(connectionFactory);
//        this.afterPropertiesSet();
//    }



}
