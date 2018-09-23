package com.yxysoft.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author Jesse
 * @date 2018/1/22
 */
@Component
@MapperScan("com.yxysoft.*.mapper")
public class MyBatisConfiguration {

}
