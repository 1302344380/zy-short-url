package cn.shorturl.web.boot.starter.controller;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.store.ShortUrlStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 18:57
 */
@Controller
@ConditionalOnProperty(prefix = "shorturl.redirect", name = "enable")
@RequestMapping("${shorturl.redirect.url-suffix}")
public class ToController {

    @Resource
    private ShortUrlStore store;

    @RequestMapping("/{hash}")
    public void to(@PathVariable String hash, HttpServletResponse response) {
        ShortUrl url = store.get(hash);
        if (url == null) {
            throw new IllegalArgumentException("hash not found");
        }
        try {
            response.sendRedirect(url.getUrl());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
