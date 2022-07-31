package cn.shorturl.store.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlUtil;
import cn.shorturl.store.ShortUrlStore;

/**
 * @author Lenovo
 */
public class RedisShortUrlStore extends ShortUrlStore {



    public RedisShortUrlStore(ShortUrlUtil util) {
        super.util = util;
    }

    @Override
    protected ShortUrl add(ShortUrl shortUrl) {
        System.out.println(shortUrl);
        return null;
    }

    @Override
    public ShortUrl get(String hash) {
        return null;
    }

}
