package cn.shorturl.web.boot.starter.controller;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.store.ShortUrlStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 16:41
 */
@Slf4j
@RestController
@ConditionalOnProperty(prefix = "shorturl.api", name = "enable")
@RequestMapping("${shorturl.api.url-suffix}")
public class ShortUrlController {

    @Resource
    private ShortUrlStore store;

    @GetMapping("${shorturl.api.add}")
    public ShortUrl add(@RequestParam String url, @RequestParam(required = false) Date expire) {
        return store.add(url, expire);
    }

    @GetMapping("${shorturl.api.get}")
    public ShortUrl get(@RequestParam String hash) {
        return store.get(hash);
    }

}
