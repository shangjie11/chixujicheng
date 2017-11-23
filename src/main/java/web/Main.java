package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
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
 * @创建时间 2017/10/17
 * @描述
 */
@RestController
@SpringBootApplication
public class Main {
    private Logger logger = LoggerFactory.getLogger(Main.class);
    @Autowired
    private Environment env ;


    @RequestMapping("/")
    public String hello(){

        return env.getProperty("shangjie.name");
    }

    @RequestMapping("/out")
    public String readOutConfig(){
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("encoding", "utf_8");
        PropertySource propertySource1 = new MapPropertySource("map", map);
        System.out.println(propertySource1.getProperty("encoding"));

        ResourcePropertySource propertySource2 = null; //name, location
        try {
            propertySource2 = new ResourcePropertySource("resource", "classpath:/config/author.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertySource2.getProperty("author.name").toString();
    }


    @RequestMapping("/outlogging")
    public String outLogging(){
        logger.debug("测试日志");
        return "hello";
    }

    public static void main(String[] args){

        SpringApplication.run(Main.class,args);
    }



}
