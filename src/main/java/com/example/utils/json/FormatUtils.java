package com.example.utils.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/6/11 14:01
 * @description: jackson json 序列化
 */
@Slf4j
public class FormatUtils {

    /**
     * 解决java8时间冲突问题
     */
    private static final ObjectMapper objectMapper = (new ObjectMapper())
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            //序列化结果中不包含null值
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            //允许：默认false_不解析含有结束语控制字符
            .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature())
            //主要是这行配置，意思是在遇到未知字段时是否失败，默认为true，也就是遇到未知字段时会报错
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public FormatUtils() {
    }

    /**
     * 对象转字符串
     *
     * @param obj 待序列化对象
     * @return 序列化后的字符串
     */
    public static <T> String obj2str(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("json:[{}] to string error", obj, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * json 转对象
     *
     * @param str   json
     * @param clazz 对象
     * @param <T>   对象类型
     * @return 反序列化后的对象
     */
    public static <T> T str2obj(String str, Class<T> clazz) {
        if (StringUtils.isBlank(str) || clazz == null) {
            return null;
        }
        try {
            return objectMapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            log.error("str:[{}] to Object error", str, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * json 转对象
     *
     * @param is    InputStream
     * @param clazz 对象
     * @param <T>   对象类型
     * @return 反序列化后的对象
     */
    public static <T> T toObject(InputStream is, Class<T> clazz) {
        if (is == null) {
            return null;
        }
        try {
            return objectMapper.readValue(is, clazz);
        } catch (IOException e) {
            log.error("InputStream to Object error", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json 为 集合
     *
     * @param src   json
     * @param clazz 对象
     * @param <T>   对象类型
     * @return 反序列化后的对象
     */
    public static <T> List<T> toArray(String src, Class<T> clazz) {
        if (src == null || clazz == null) {
            return null;
        }
        try {
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(src, javaType);
        } catch (JsonProcessingException e) {
            log.error("parse json[{}] to array error", src, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * json 字符串转换成对象
     *
     * @param str           json 字符串
     * @param typeReference 转换类型 TypeReference<T> type = new TypeReference<T>() {};
     * @return
     */
    public static <T> T str2obj(String str, TypeReference<T> typeReference) {
        try {
            return StringUtils.isEmpty(str) ? null : objectMapper.readValue(str, typeReference);
        } catch (JsonProcessingException e) {
            log.error("jackson str2obj error, str={}, e={}", str, e.getMessage());
            return null;
        }
    }

    /**
     * 从json串中获取某个节点的值：子json
     *
     * @param src json
     * @return 子json
     */
    public static String childJson(String src, String node) {
        try {
            JsonNode jsonNode = objectMapper.readTree(src);
            return jsonNode.get(node).toString();
        } catch (Exception e) {
            log.error("parse json[{}] node[{}], error", src, node, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 从json串中获取某个节点的值：json的节点的值
     *
     * @param src json
     * @return string
     */
    public static String childStr(String src, String node) {
        try {
            JsonNode jsonNode = objectMapper.readTree(src);
            return jsonNode.get(node).asText();
        } catch (Exception e) {
            log.error("get json[{}] node[{}], error", src, node, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 从json串中获取某个节点的值：json的节点的值
     *
     * @param src json
     * @return int
     */
    public static int childInt(String src, String node) {
        try {
            JsonNode jsonNode = objectMapper.readTree(src);
            return jsonNode.get(node).asInt();
        } catch (Exception e) {
            log.error("get json[{}] node[{}], error", src, node, e);
            throw new RuntimeException(e);
        }
    }

}
