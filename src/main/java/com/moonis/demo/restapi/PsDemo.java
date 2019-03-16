package com.moonis.demo.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;


@ServletComponentScan
@SpringBootApplication
public class PsDemo extends SpringBootServletInitializer {
	
	private static Class<PsDemo> dashboardRestApi = PsDemo.class;

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(dashboardRestApi);
	    }

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(dashboardRestApi, args);
	    }

	
	
	/*public static void main(String[] args) {
		SpringApplication.run(ProskilsDashboardRestAPI.class, args);
	}*/

	/**
	 * 
	 * @param mongoDbFactory
	 * @param context
	 * @return
	 */
	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoMappingContext context) {

		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

		return mongoTemplate;

	}

	/**
	 * 
	 * @return
	 */
	
}
