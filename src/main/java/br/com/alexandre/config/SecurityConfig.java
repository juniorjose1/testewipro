package br.com.alexandre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.HandlerExceptionResolver;

import br.com.alexandre.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private HandlerExceptionResolver handlerExceptionResolver;
	
	@Autowired
	private UsuarioRepository usuRepo;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		String usuarioLogin = usuRepo.procurarPorLogin();
		
		String usuarioSenha = usuRepo.procurarPorSenha();
		
		auth.inMemoryAuthentication()
			.withUser(usuarioLogin).password("{noop}" + usuarioSenha).roles("ROLE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.and().authorizeRequests()
			.antMatchers("/h2-console/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.csrf().disable()		
		.exceptionHandling().authenticationEntryPoint((request, response, exception) -> {
			this.handlerExceptionResolver.resolveException(request, response, null, exception);
		});
		http.headers().frameOptions().disable();
		
	}
	
	

}
