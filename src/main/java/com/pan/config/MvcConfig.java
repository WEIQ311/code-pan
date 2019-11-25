package com.pan.config;

import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MvcConfig
 *
 * @author weiqiang
 * @Description 解决跨域、swagger拦截等配置
 * @Date 2019/11/25
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Configure how long in seconds the response from a pre-flight request can be cached by clients.
     */
    @Value("${common.mvc.maxAge:3600}")
    private Integer maxAge;

    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*", "*/*", "/webjars/**", "/static/*", "templates/*")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/", "classpath:/static/", "classpath:/templates/");
    }

    /**
     * Configure cross origin requests processing.
     *
     * @param registry
     * @since 4.2
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.DELETE.name(), HttpMethod.PUT.name())
                .maxAge(3600);
    }
}
