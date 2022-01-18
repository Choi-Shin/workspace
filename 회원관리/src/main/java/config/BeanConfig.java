package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.stone.simple.member.presentation.*;
import com.stone.simple.member.dataservice.*;
import com.stone.simple.member.service.*;



@Configuration
public class BeanConfig {
	
	@Bean
	public Id중복검사컨트롤러 Id중복검사컨트롤러( ) {
		return new Id중복검사컨트롤러( );
	}
	@Bean
	public 회원관리자 회원관리자( ) {
		return new 회원관리자( );
	}
	@Bean
	public 회원DAO 회원DAO( ) {
		return new 회원DAO( );
	}
}
