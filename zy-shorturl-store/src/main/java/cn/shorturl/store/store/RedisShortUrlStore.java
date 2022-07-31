package cn.shorturl.store.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlConfig;
import cn.shorturl.store.ShortUrlStore;

/**
 * @author Lenovo
 */
public class RedisShortUrlStore implements ShortUrlStore {

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
