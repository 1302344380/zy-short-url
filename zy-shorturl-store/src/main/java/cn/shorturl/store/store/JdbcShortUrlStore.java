package cn.shorturl.store.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlUtil;
import cn.shorturl.store.ShortUrlStore;

/**
 * @author Lenovo
 */
public class JdbcShortUrlStore extends ShortUrlStore {

    public JdbcShortUrlStore(ShortUrlUtil util) {
        super.util = util;
    }

    @Override
    protected ShortUrl add(ShortUrl shortUrl) {
        return null;
    }

    @Override
    public ShortUrl get(String hash) {
        return null;
    }

    @Override
    public boolean contains(String hash) {
        return false;
    }

}
