package br.com.java.product.api.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReadApplicationPropertiesTest {

    @Autowired
    ReadApplicationProperties properties = new ReadApplicationProperties();

    @Test
    public void readingTheRightValueFromPropertiesFile() {

        assertThat(properties.getCountry().equals("US"));
        assertThat(properties.getLanguage().equals("en"));
    }

}
