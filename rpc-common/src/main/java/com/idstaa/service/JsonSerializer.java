package com.idstaa.service;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * @author chenjie
 * @date 2020/12/19 16:22
 */
public class JsonSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) throws Exception {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return  JSON.parseObject(bytes,clazz);
    }
}
