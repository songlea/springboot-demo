package com.songlea.springboot.demo.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 场景-获取非appliction.properties配置文件的demo
 *
 * @author Song Lea
 */
@Component
// 新版本ConfigurationProperties取消了locations,使用PropertySource代替
@PropertySource("classpath:other-config-file.properties")
@ConfigurationProperties(prefix = "other.config")
public class OtherFileConfig {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
