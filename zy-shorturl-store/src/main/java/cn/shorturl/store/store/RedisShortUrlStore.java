package cn.shorturl.store.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlUtil;
import cn.shorturl.store.ShortUrlStore;
import cn.shorturl.store.exception.HashAlreadyException;
import cn.shorturl.store.template.ShortUrlRedisTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Lenovo
 */
public class RedisShortUrlStore extends ShortUrlStore {

    ShortUrlRedisTemplate redisTemplate;

    public static final String SHORT_KEY = "short:url:";

    public RedisShortUrlStore(ShortUrlUtil util, ShortUrlRedisTemplate redisTemplate) {
        super.util = util;
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected ShortUrl add(ShortUrl shortUrl) {
        System.out.println(shortUrl);
        String key = SHORT_KEY + shortUrl.getHash();
        Date expire = shortUrl.getGmtExpire();
        Boolean save;
        if (expire != null) {
            long time = expire.getTime() - System.currentTimeMillis();
            if (time < 0) {
                return null;
            }
            save = redisTemplate.opsForValue().setIfAbsent(key, shortUrl, time, TimeUnit.MILLISECONDS);
        } else {
            save = redisTemplate.opsForValue().setIfAbsent(key, shortUrl);
        }
        if (!Boolean.TRUE.equals(save)) {
            throw new HashAlreadyException("hash already exists");
        }
        return shortUrl;
    }

    @Override
    public ShortUrl get(String hash) {
        return redisTemplate.opsForValue().get(SHORT_KEY + hash);
    }

    @Override
    public boolean contains(String hash) {
        return redisTemplate.opsForValue().get(SHORT_KEY + hash) != null;
    }

}
