package cn.shorturl.web.controller;

import cn.shorturl.core.ShortUrlConfig;
import cn.shorturl.store.ShortUrlStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 16:41
 */
@Slf4j
@RestController
@RequestMapping("/su")
public class ShortUrlController {

    @Resource
    private ShortUrlConfig shortUrlConfig;

    @Resource
    private ShortUrlStore store;

    @PostConstruct
    public void init() {
        log.info("shortUrlConfig: {}", shortUrlConfig);
        log.info("store: {}", store);
    }

    @GetMapping("/gen")
    public String gen() {
        return "";
    }

}
