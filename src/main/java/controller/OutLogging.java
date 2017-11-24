package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 shangjie
 * @创建时间 2017/10/18
 * @描述
 */
@RestController
public class OutLogging {
    //private static final Logger = LoggerFactory.getLogger(OutLogging.class);
    private Logger logger = LoggerFactory.getLogger(OutLogging.class);
    @RequestMapping("/outlogging")
    public String outLogging(){
        logger.debug("测试日志");
		logger.debug("测试git代码提交更新");
        return "hello";
    }
}
