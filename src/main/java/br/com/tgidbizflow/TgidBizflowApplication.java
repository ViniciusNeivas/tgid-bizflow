package br.com.tgidbizflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("br.com.tgidbizflow.model.company")
public class TgidBizflowApplication {
    public static void main(String[] args) {
        SpringApplication.run(TgidBizflowApplication.class, args);
    }
}

