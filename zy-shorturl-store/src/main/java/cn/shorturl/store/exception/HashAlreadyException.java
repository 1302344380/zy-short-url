package cn.shorturl.store.exception;

/**
 * @author ZhuoQinghui
 * @version 1.0.0
 * Create By 2022/7/31 18:49
 */
public class HashAlreadyException extends RuntimeException {

    public HashAlreadyException() {
    }

    public HashAlreadyException(String message) {
        super(message);
    }

}
