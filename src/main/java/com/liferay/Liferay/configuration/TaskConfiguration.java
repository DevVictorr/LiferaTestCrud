package com.liferay.Liferay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liferay.Liferay.service.TaskService;

@Configuration
public class TaskConfiguration {



    @Bean
    public TaskService taskService(){
        return new TaskService();
    }

}
