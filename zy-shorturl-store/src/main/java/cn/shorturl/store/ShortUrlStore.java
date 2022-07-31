package cn.shorturl.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlUtil;

import java.util.Date;

/**
 * @author Lenovo
 */
public abstract class ShortUrlStore {

    protected ShortUrlUtil util;

    /**
     * 添加短连接(外部访问)
     * @param url 原链接
     * @return 短连接
     */
    public ShortUrl add(String url) {
        return add(url, null);
    }

    /**
     * 添加短链接(外部访问)
     * @param url 原链接
     * @param expireTime 过期时间
     * @return 短连接
     */
    public ShortUrl add(String url, Date expireTime) {
        Integer max = util.getConfig().getRetryMax();
        if (max == null || max < 1) {
            max = 10;
        }
        ShortUrl shortUrl = new ShortUrl().setUrl(url).setGmtExpire(expireTime).setGmtCreate(new Date());
        for (int i = 0; i < max; i++) {
            String hash = hash(url);
            if (contains(hash)) {
                url += (int) (Math.random() * 10);
                continue;
            }
            try {
                shortUrl.setHash(hash);
                add(shortUrl);
                return shortUrl;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("add short url failed");
    }

    /**
     * 添加短链接(内部访问, 请勿外部访问)
     * @param shortUrl 短链接
     * @return 短链接
     */
    protected abstract ShortUrl add(ShortUrl shortUrl);

    /**
     * 获取短链接
     * @param hash 短链接
     * @return 原链接
     */
    public abstract ShortUrl get(String hash);

    /**
     * Hash是否已经存在
     * @param hash Hash
     * @return 是否已经存在
     */
    public abstract boolean contains(String hash);

    /**
     * 对URL进行Hash编码
     * @param url 原链接
     * @return 短链接
     */
    public String hash(String url) {
        return util.gen(url);
    }

}
