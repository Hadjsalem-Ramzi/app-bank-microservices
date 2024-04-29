package net.hadjsalem.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
public class GlobalConfig {
    private int p1;
    private int p2;
}
