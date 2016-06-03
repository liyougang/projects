package com.ligang.demo.web.util;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil
{
  public static String toJSonString(Object obj)
  {
    ObjectMapper mapper = new ObjectMapper();
    StringWriter out = new StringWriter();
    try
    {
      JsonGenerator gen = new JsonFactory().createJsonGenerator(out);
      gen.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
      mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
      mapper.writeValue(gen, obj);
      gen.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return out.toString();
  }

 

  public static String toJSonString(Object obj, String dateFormat)
  {
    ObjectMapper mapper = new ObjectMapper();
    StringWriter out = new StringWriter();
    try
    {
      JsonGenerator gen = new JsonFactory().createJsonGenerator(out);
      gen.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
      mapper.setDateFormat(new SimpleDateFormat(dateFormat));
      mapper.writeValue(gen, obj);
      gen.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return out.toString();
  }
  
  public static <T> T toObject(String json, Class<T> clazz)
  {
    ObjectMapper mapper = new ObjectMapper();

    T t = null;
    try {
      mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
      t = mapper.readValue(json, clazz);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return t;
  }

  public static <T> T toObject(String json, Class<T> clazz, String dateFormat)
  {
    ObjectMapper mapper = new ObjectMapper();
    T t = null;
    try {
      mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      mapper.setDateFormat(new SimpleDateFormat(dateFormat));
      t = mapper.readValue(json, clazz);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return t;
  }
  
}