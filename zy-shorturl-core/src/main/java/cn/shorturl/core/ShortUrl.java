package cn.shorturl.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Lenovo
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ShortUrl {

    /**
     * 短连接
     */
    private String hash;

    /**
     * 原链接
     */
    private String url;

    /**
     * 原链接长度(在Hash冲突时, 给原链接加上随机数并重新生成短链接, 通过Hash获取原链接是还原原链接)
     */
    @Deprecated
    private Integer urlLength;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 有效时间(秒)
     */
    @Deprecated
    private Long validityTime;

    /**
     * 过期时间
     */
    private Date gmtExpire;

}
