package com.service.order.profile;


import com.service.order.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfile {

    @Autowired
    private DbService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public boolean instacia() {
        if (ddl.equals("create-drop")) {
            this.dbService.instaciaDB();
        }
        return false;

    }

}
