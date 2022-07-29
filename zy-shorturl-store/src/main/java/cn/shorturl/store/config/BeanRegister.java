package cn.shorturl.store.config;

import cn.shorturl.core.ShortUrlConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lenovo
 */
@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "cn.shorturl.store")
public class BeanRegister {

    @ConfigurationProperties(prefix = "shorturl.store")
    public ShortUrlConfig shortUrlConfig(ShortUrlConfig shortUrlConfig) {
        return shortUrlConfig;
    }

}
