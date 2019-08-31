package xyz.lennon.laotao_server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
class MyMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**").addResourceLocations("/home/l/laotao/img/");
        registry.addResourceHandler("/**").addResourceLocations("file:/home/l/laotao/img/");
        super.addResourceHandlers(registry);
    }
}
