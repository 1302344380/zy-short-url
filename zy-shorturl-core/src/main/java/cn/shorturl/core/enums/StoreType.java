package cn.shorturl.core.enums;

/**
 * data store type
 * @author Lenovo
 */
public enum StoreType {

    /**
     * mysql, sqlserver, oracle 等支持jdbc的数据库
     */
    JDBC,

    /**
     * redis
     */
    REDIS,

    /**
     * mongodb
     */
    MONGODB,

    /**
     * Hazelcast
     */
    HAZELCAST,

    /**
     * 内存
     */
    MEMORY,

}
