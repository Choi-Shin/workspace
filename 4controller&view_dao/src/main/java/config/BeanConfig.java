package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springmvc.presentation.BoardController;

@Configuration
public class BeanConfig {
	@Bean
	public BoardController BoardController( ) {
		return new BoardController( );
	} 
}
