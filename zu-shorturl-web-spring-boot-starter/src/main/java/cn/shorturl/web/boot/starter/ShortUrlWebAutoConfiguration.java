package cn.shorturl.web.boot.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 19:41
 */
@Slf4j
@Configuration
@ComponentScan("cn.shorturl.web.boot.starter.controller")
@EnableConfigurationProperties
public class ShortUrlWebAutoConfiguration {
}
