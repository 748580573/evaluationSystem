package com.feng.tool;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static final ObjectMapper WRITER = new ObjectMapper();

    public static <T> String asJson(T t){
        try {
            return WRITER.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            return "转换失败";
        }
    }
}
