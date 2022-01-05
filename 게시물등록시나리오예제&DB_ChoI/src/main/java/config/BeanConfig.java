package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.dataservice.게시물DAO;
import com.stone.springmvc.presentation.게시물관리컨트롤러;
import com.stone.springmvc.service.BoardService;

@Configuration
public class BeanConfig {
	@Bean
	public 게시물관리컨트롤러 어떤컨트롤러( ) {
		return new 게시물관리컨트롤러( );
	}
	
	@Bean
	public BoardService boardService() {
		return new BoardService();
	}
	
	@Bean
	public 게시물DAO 게시물dao() {
		return 게시물DAO.getInstance();
	}
	
}
