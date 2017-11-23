package service;

import org.junit.Test;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 shangjie
 * @创建时间 2017/10/18
 * @描述
 */

public class ReadConfig {
    @Test
    public void test00()throws IOException{
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("encoding", "utf_8");
        PropertySource propertySource1 = new MapPropertySource("map", map);
        System.out.println(propertySource1.getProperty("encoding"));

        ResourcePropertySource propertySource2 = new ResourcePropertySource("resource", "classpath:/config/author.properties"); //name, location
        System.out.println(propertySource2.getProperty("author.name"));
    }
}
