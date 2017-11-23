package controller;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人 shangjie
 * @创建时间 2017/10/18
 * @描述
 */
@RestController
public class ReadConfig {
    @RequestMapping("/outConfig")
    public String readOutConfig(){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("encoding", "utf_8");
        PropertySource propertySource1 = new MapPropertySource("map", map);
        System.out.println(propertySource1.getProperty("encoding"));

        ResourcePropertySource propertySource2 = null; //name, location
        try {
            propertySource2 = new ResourcePropertySource("resource", "classpath:/resource/config/author.properties");
        } catch (IOException e) {
         }
        return propertySource2.getProperty("author.name").toString();
    }
}
