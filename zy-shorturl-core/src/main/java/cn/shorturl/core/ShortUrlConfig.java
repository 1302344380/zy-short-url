package cn.shorturl.core;

import cn.shorturl.core.enums.HashType;
import cn.shorturl.core.enums.StoreType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Lenovo
 */
@Data
@Accessors(chain = true)
public class ShortUrlConfig {

    /**
     * Hash方式
     */
    private HashType hashType = HashType.MURMUR3_32_FIXED;

    private String hashKey = ShortUrlConfig.class.getName();

    /**
     * 缓存类型
     */
    private StoreType storeType = StoreType.MEMORY;

}
