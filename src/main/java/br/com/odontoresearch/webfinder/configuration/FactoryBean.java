package br.com.odontoresearch.webfinder.configuration;

import br.com.odontoresearch.webfinder.external.PubMedConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBean{
    @Bean
    public @Autowired
    PubMedConsumer createPubMedConsumer() {
        return new PubMedConsumer();
    }
}
