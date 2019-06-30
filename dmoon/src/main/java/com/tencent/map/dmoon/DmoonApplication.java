package com.tencent.map.dmoon;

import com.tencent.map.dmoon.listener.*;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DmoonApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication app = new SpringApplication(DmoonApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.addListeners(new AppStartingListener(), new AppEnvironmentListener(),
                new AppPreparedListener(), new AppStartedListener(), new AppReadyListener());
        app.run(args);
        //SpringApplication.run(DmoonApplication.class, args);
/*        new SpringApplicationBuilder()
                .sources(DmoonApplication.class)
                .child(DmoonApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);*/
    }

}
