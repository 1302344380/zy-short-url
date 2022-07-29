package cn.shorturl.core;

import cn.shorturl.core.enums.HashType;
import org.junit.Before;
import org.junit.Test;

public class ShortUrlUtilTest {

    ShortUrlConfig config;

    ShortUrlUtil shortUrlUtil;

    @Before
    public void init() {
        config = new ShortUrlConfig().setHashType(HashType.MURMUR3_32_FIXED);
        shortUrlUtil = new ShortUrlUtil(config);
    }

    @Test
    public void testGen() {
        String url = "http://www.baidu.com//?asdasdasdaas=das==wqe===gfa=sd=asf=g=eq=w===a=sd=as=fg=w=d=as=d=as=f=w=";
        String gen = shortUrlUtil.gen(url);
        System.out.println(gen);
    }

}