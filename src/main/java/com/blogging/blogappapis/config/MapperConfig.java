package com.blogging.blogappapis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
    public class MapperConfig {

        @Bean
        public ModelMapper modelMapper(){
            ModelMapper modelMapper = new ModelMapper();
            return new ModelMapper();
        }
    }
