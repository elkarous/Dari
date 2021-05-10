package tn.esprit.spring.security;




import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.service.UserService;



@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	  private final UserService userDetailsService;
	  private final BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userDetailsService = userDetailsService;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http
		    .cors().and()
		    .csrf().disable()
			.authorizeRequests()
	          .antMatchers("/bank/deleteBank/{id}").authenticated()
	          .antMatchers("/bank/addBank").authenticated()
	          .antMatchers("/bank/updateBank").authenticated()
	          .antMatchers("/bank//deleteBankOffre/{bankId}/{id}").authenticated()
	          .antMatchers("/bank//addBankOffre/{bankId}").authenticated()
	          .antMatchers("/bank/updateBankOffre").authenticated()
	          .antMatchers("/simulation/simulationByIrSave").authenticated()
	          .antMatchers("/estimation/addunitprice").authenticated()
	          .antMatchers("/estimation/updateunitprice").authenticated()
	          .antMatchers("/estimation/deleteunitprice/{id}").authenticated()
	          .anyRequest().permitAll()
			.and()
			.addFilter(getAuthenticationFilter())
			.addFilter(new AuthorizationFilter(authenticationManager()))
			.sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		    
		  
	}
	
	
	
	
	protected AuthenticationFilter getAuthenticationFilter() throws Exception {
	    final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
	    filter.setFilterProcessesUrl("/users/login");
	    return filter;
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
}
