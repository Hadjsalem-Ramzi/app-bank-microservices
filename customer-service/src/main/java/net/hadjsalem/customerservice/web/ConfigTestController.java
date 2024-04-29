package net.hadjsalem.customerservice.web;
import net.hadjsalem.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    private int p1 ;
    private int p2;
    private int x;
    private int y;


    private GlobalConfig globalConfig;
    @Autowired
    public ConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }





    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);

    }

    @GetMapping("/globalConfig")
    public GlobalConfig GlobalConfig() {
        return globalConfig;
    }
}
