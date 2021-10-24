package ou.acs.security;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/api/auth/*";
    public static final String SECRET = "$2a$12$6fgAepVBm26AFkqnohS6uO1QFhqT7ZxJFffBhaX0MrMIfmcey9kR2";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000; //10min

}
