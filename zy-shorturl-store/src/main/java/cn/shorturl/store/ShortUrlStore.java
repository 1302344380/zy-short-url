package cn.shorturl.store;

import cn.shorturl.core.ShortUrl;
import cn.shorturl.core.ShortUrlConfig;
import cn.shorturl.core.ShortUrlUtil;

import java.util.Date;

/**
 * @author Lenovo
 */
public interface ShortUrlStore {

    /**
     * 添加短连接(外部访问)
     * @param url 原链接
     * @return 短连接
     */
    default ShortUrl add(String url) {
        return add(url, null);
    }

    /**
     * 添加短链接(外部访问)
     * @param url 原链接
     * @param expireTime 过期时间
     * @return 短连接
     */
    default ShortUrl add(String url, Date expireTime) {
        Integer max = getConfig().getRetryMax();
        if (max == null) {
            max = 5;
        }
        ShortUrl shortUrl = new ShortUrl().setUrl(url).setGmtExpire(expireTime).setGmtCreate(new Date());
        for (int i = 0; i < max; i++) {
            String hash = hash(url);
            try {
                shortUrl.setHash(hash);
                add(shortUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("add short url failed");
    }

    /**
     * 添加短链接(内部访问, 请勿外部访问)
     * @param shortUrl 短链接
     */
    ShortUrl add(ShortUrl shortUrl);

    /**
     * 获取短链接
     * @param hash 短链接
     * @return 原链接
     */
    ShortUrl get(String hash);

    /**
     * 对URL进行Hash编码
     * @param url 原链接
     * @return 短链接
     */
    String hash(String url);

    /**
     * 获取配置对象
     * @return 配置对象
     */
    ShortUrlConfig getConfig();

}
