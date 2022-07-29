package cn.shorturl.store.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlConfig;
import cn.shorturl.store.ShortUrlStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.annotation.PostConstruct;

/**
 * @author Lenovo
 */
@ConditionalOnProperty(prefix = "shorturl.store", name = "storeType", havingValue = "redis")
public class RedisShortUrlStore implements ShortUrlStore {

    @PostConstruct
    public void init() {
        System.out.println("RedisShortUrlStore init");
    }

    @Override
    public ShortUrl add(ShortUrl shortUrl) {
        return null;
    }

    @Override
    public ShortUrl get(String hash) {
        return null;
    }

    @Override
    public String hash(String url) {
        return null;
    }

    @Override
    public ShortUrlConfig getConfig() {
        return null;
    }
}
