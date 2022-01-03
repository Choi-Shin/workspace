package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.presentation.게시물관리컨트롤러;

@Configuration
public class BeanConfig {
	@Bean
	public 게시물관리컨트롤러 어떤컨트롤러( ) {
		return new 게시물관리컨트롤러( );
	}
	
	
}
