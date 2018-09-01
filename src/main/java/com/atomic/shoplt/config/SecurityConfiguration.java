package com.atomic.shoplt.config;

import com.atomic.shoplt.security.AjaxAuthenticationFailureHandler;
import com.atomic.shoplt.security.AjaxAuthenticationSuccessHandler;
import com.atomic.shoplt.security.AjaxLogoutSuccessHandler;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Import(SecurityProblemSupport.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	private final UserDetailsService userDetailsService;

	//private final RememberMeServices rememberMeServices;

	private final CorsFilter corsFilter;

	private final SecurityProblemSupport problemSupport;
	
	public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService,
			 CorsFilter corsFilter, SecurityProblemSupport problemSupport)
	{
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.userDetailsService = userDetailsService;
		//this.rememberMeServices = rememberMeServices;
		this.corsFilter = corsFilter;
		this.problemSupport = problemSupport;
	}

	@PostConstruct
	public void init()
	{
		try
		{
			authenticationManagerBuilder
					.userDetailsService(userDetailsService)
					.passwordEncoder(passwordEncoder());
		}
		catch(Exception e)
		{
			throw new BeanInitializationException("Security configuration failed", e);
		}
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean
	public AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler()
	{
		return new AjaxAuthenticationSuccessHandler();
	}

	@Bean
	public AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler()
	{
		return new AjaxAuthenticationFailureHandler();
	}

	@Bean
	public AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler()
	{
		return new AjaxLogoutSuccessHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring()
				.antMatchers(HttpMethod.OPTIONS, "/**")
				.antMatchers("/app/**/*.{js,html}")
				.antMatchers("/i18n/**")
				.antMatchers("/content/**")
				.antMatchers("/swagger-ui/index.html")
				.antMatchers("/test/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		/*http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and()
				.addFilterBefore(corsFilter, CsrfFilter.class)
				.exceptionHandling()
				.authenticationEntryPoint(problemSupport)
				.accessDeniedHandler(problemSupport)
//				.and()
//				.rememberMe()
//				.rememberMeServices(rememberMeServices)
//				.rememberMeParameter("remember-me")
//				.key("rememberMe")			
			.and()
				.formLogin()
				.loginProcessingUrl("/login")
				.successHandler(ajaxAuthenticationSuccessHandler())
				.failureHandler(ajaxAuthenticationFailureHandler())
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(ajaxLogoutSuccessHandler())
				.permitAll()
			.and()
				.headers()
				.frameOptions()
				.disable()
			.and()
				.authorizeRequests()
				.anyRequest().authenticated()
			.and()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/api/register").permitAll()
				.antMatchers("/api/activate").permitAll()
				.antMatchers("/api/authenticate").permitAll()
				.antMatchers("/api/account/reset-password/init").permitAll()
				.antMatchers("/api/account/reset-password/finish").permitAll()
				.antMatchers("/api/**").authenticated()
				.antMatchers("/websocket/**").hasAuthority(AuthoritiesConstants.USER)
				.antMatchers("/management/**").hasAuthority(AuthoritiesConstants.ADMIN)
				;*/
		http.
			authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				.authenticated()
			.and()
				.csrf()
					.disable()
			.formLogin()
				.loginPage("/login")
					.failureUrl("/login?error=true")
					.defaultSuccessUrl("/admin/home")
					.usernameParameter("email")
					.passwordParameter("password")
			.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/")
			.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied");
	}
}
