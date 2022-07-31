package cn.shorturl.boot.starter;

import cn.shorturl.core.ShortUrlConfig;
import cn.shorturl.core.ShortUrlUtil;
import cn.shorturl.store.ShortUrlStore;
import cn.shorturl.store.store.JdbcShortUrlStore;
import cn.shorturl.store.store.RedisShortUrlStore;
import cn.shorturl.store.template.ShortUrlRedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 16:25
 */
@Slf4j
@Configuration
@EnableConfigurationProperties
public class ShortUrlAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(ShortUrlConfig.class)
    @ConfigurationProperties(prefix = "shorturl.store")
    public ShortUrlConfig shortUrlConfig() {
        return new ShortUrlConfig();
    }

    @Bean
    @ConditionalOnMissingBean(ShortUrlUtil.class)
    @ConditionalOnBean(ShortUrlConfig.class)
    public ShortUrlUtil shortUrlUtil(ShortUrlConfig config) {
        return new ShortUrlUtil(config);
    }

    @Bean
    @ConditionalOnMissingBean(ShortUrlStore.class)
    @ConditionalOnBean(ShortUrlUtil.class)
    @ConditionalOnProperty(prefix = "shorturl.store", name = "store-type", havingValue = "redis")
    public ShortUrlStore redisShortUrlStore(ShortUrlUtil util, RedisConnectionFactory connectionFactory) {
        log.info("use short-url store: {}", RedisShortUrlStore.class.getName());
        return new RedisShortUrlStore(util, new ShortUrlRedisTemplate(connectionFactory));
    }

    @Bean
    @ConditionalOnMissingBean(ShortUrlStore.class)
    @ConditionalOnBean(ShortUrlUtil.class)
    @ConditionalOnProperty(prefix = "shorturl.store", name = "store-type", havingValue = "jdbc")
    public ShortUrlStore jdbcShortUrlStore(ShortUrlUtil util) {
        log.info("use short-url store: {}", RedisShortUrlStore.class.getName());
        return new JdbcShortUrlStore(util);
    }

}
