package tn.esprit.spring.security;

public interface SecurityConstants {
    String AUTHORIZATION_HEADER_STRING = "Authorization";
    String TOKEN_BEARER_PREFIX = "Bearer ";
    Integer ACCESS_TOKEN_EXPIRATION = 60000000; // minutes
     String SIGN_UP_URL = "/users";
	 String TOKEN_SECRET = "dfg893hdc475zwerop4tghg4ddfdfgdsdfeqaas?=-0ljznm0-9";
}
