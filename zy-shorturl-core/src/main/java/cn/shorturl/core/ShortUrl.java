package cn.shorturl.core;

import cn.shorturl.core.enums.HashType;
import cn.shorturl.core.util.Base62;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import lombok.Data;
import lombok.experimental.Accessors;

import java.nio.charset.StandardCharsets;

/**
 * @author Lenovo
 */
@Data
@Accessors(chain = true)
public class ShortUrl {

    private ShortUrlConfig config;

    private final HashFunction hashFunction;

    private static final Base62 base62 = Base62.createInstance();

    public ShortUrl() {
        config = new ShortUrlConfig();
        hashFunction = getHashFunction(config);
    }

    public ShortUrl(ShortUrlConfig config) {
        this.config = config;
        hashFunction = getHashFunction(config);
    }

    public String gen(String url) {
        HashCode hashCode = hashFunction.hashString(url, StandardCharsets.UTF_8);
        byte[] bytes = hashCode.asBytes();
        return new String(base62.encode(bytes));
    }

    private static HashFunction getHashFunction(ShortUrlConfig config) {
        return getHashFunction(config.getHashType(), config.getHashKey());
    }

    private static HashFunction getHashFunction(HashType type, String key) {
        if (type == null) {
            return Hashing.murmur3_32_fixed();
        }
        if (key == null) {
            key = ShortUrl.class.getName();
        }
        byte[] keyBytes = key.getBytes();
        switch (type) {
            case MD5: return Hashing.md5();
            case GOOD_FAST_HASH: return Hashing.goodFastHash(32);
            case SHA1: return Hashing.sha1();
            case SHA256: return Hashing.sha256();
            case SHA384: return Hashing.sha384();
            case SHA512: return Hashing.sha512();
            case HMAC_MD5: return Hashing.hmacMd5(keyBytes);
            case HMAC_SHA1: return Hashing.hmacSha1(keyBytes);
            case HMAC_SHA256: return Hashing.hmacSha256(keyBytes);
            case HMAC_SHA512: return Hashing.hmacSha512(keyBytes);
            case CRC32_C: return Hashing.crc32c();
            case ADLER32: return Hashing.adler32();
            case FARM_HASH_FINGERPRINT64: return Hashing.farmHashFingerprint64();
            case FINGERPRINT2011: return Hashing.fingerprint2011();
            case MURMUR3_32: return Hashing.murmur3_32();
            case MURMUR3_128: return Hashing.murmur3_128();
            case SIP_HASH24: return Hashing.sipHash24();
            case MURMUR3_32_FIXED:
            default: return Hashing.murmur3_32_fixed();
        }
    }

}
