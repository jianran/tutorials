package com.baeldung.springdatageode.locator;

import com.baeldung.springdatageode.server.fn.AverageAgeFunctionImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;

/**
	* @author <a href="mailto:josh@joshlong.com">Josh Long</a>
	*/
@ComponentScan(basePackageClasses =
	{LocatorApplication.class, AverageAgeFunctionImpl.class})
@CacheServerApplication(locators = "localhost[10334]")
@SpringBootApplication
public class LocatorApplication {

	@Configuration
	@EnableLocator
	@EnableManager(start = true)
	public static class LocatorConfiguration {
	}

	public static void main(String args[]) {
		SpringApplication.run(LocatorApplication.class, args);
	}
}
