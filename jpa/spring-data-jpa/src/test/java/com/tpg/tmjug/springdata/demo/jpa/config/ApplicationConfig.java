package com.tpg.tmjug.springdata.demo.jpa.config;

import com.tpg.tmjug.springdata.demo.jpa.config.InfrastructureConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * JavaConfig class to enable Spring Data JPA repositories. Re-using common infrastructure configuration from
 * {@link InfrastructureConfig}.
 *
 * @author Oliver Gierke
 */
@Configuration
@EnableJpaRepositories
@Import(InfrastructureConfig.class)
public class ApplicationConfig {

}