package br.com.oficina.infra

import org.springframework.context.annotation.Configuration
import org.springframework.http.CacheControl
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.util.concurrent.TimeUnit
//
//@Configuration
//@EnableWebMvc
//class WebConfig : WebMvcConfigurer {
//    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
//        registry.addResourceHandler("/images/**")
//            .addResourceLocations("classpath:/static/images/")
//            .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
//    }
//}