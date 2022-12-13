/**
 *  habilitar os acessos
 */
package com.cleanmapping.CmApp.domain.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
*
* @author Equipe Clean Mapping - Kaylane e Renan
*/
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
     .allowedOrigins("*")
     .allowedHeaders("/*")
     .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
