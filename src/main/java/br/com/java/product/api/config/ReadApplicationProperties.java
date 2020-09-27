package br.com.java.product.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ReadApplicationProperties {
    @Value( "${application.country}" )
    private String country;

    @Value( "${application.language}" )
    private String language;


    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }
}
