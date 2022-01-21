package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.stone.springmvc.presentation.게시물컨트롤러;
import com.stone.springmvc.service.게시물업무자;
@Configuration
public class BeanConfig {
	
	@Bean
	public 게시물컨트롤러 게시물컨트롤러( ) {//@Controller
		return new 게시물컨트롤러( );
	}	
	
	
	@Bean
	public 게시물업무자 게시물업무자( ) {//@Service
		return new 게시물업무자( );
	}
}
