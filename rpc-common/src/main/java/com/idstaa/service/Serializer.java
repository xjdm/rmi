package com.idstaa.service;

import java.io.IOException;

/**
 * @author chenjie
 * @date 2020/12/19 16:20
 */
public interface Serializer {
    /**
     * java 对象转二进制
     * @param object
     * @return
     * @throws Exception
     */
    byte[] serialize(Object object) throws  Exception;

    /**
     * 二进制转成java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(Class<T> clazz,byte[] bytes) throws IOException;
}
