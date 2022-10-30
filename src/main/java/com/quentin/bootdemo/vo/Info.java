package com.quentin.bootdemo.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author quentin
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "mine.info")
public class Info {
    private String text;
    private String version;

    public Info(String text, String version) {
        this.text = text;
        this.version = version;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
