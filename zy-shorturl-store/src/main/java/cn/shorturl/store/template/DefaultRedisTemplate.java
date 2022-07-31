package cn.shorturl.store.template;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 18:07
 */
public class DefaultRedisTemplate<K, V> extends RedisTemplate<K, V> {
    public DefaultRedisTemplate(Class<K> kClass, Class<V> vClass) {
        if (kClass.equals(String.class)) {
            this.setKeySerializer(RedisSerializer.string());
            this.setHashKeySerializer(RedisSerializer.string());
        } else {
            this.setKeySerializer(new Jackson2JsonRedisSerializer<>(kClass));
            this.setHashKeySerializer(new Jackson2JsonRedisSerializer<>(kClass));
        }
        this.setValueSerializer(new Jackson2JsonRedisSerializer<>(vClass));
        this.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(vClass));
    }

    public DefaultRedisTemplate(Class<K> kClass, Class<V> vClass, RedisConnectionFactory connectionFactory) {
        this(kClass, vClass);
        this.setConnectionFactory(connectionFactory);
        this.afterPropertiesSet();
    }

}
