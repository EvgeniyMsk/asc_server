package ou.acs.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ou.acs.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenProvider {
    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + SecurityConstants.EXPIRATION_TIME);
        Map<String, Object> claimsMap = new HashMap<>();
        String username = user.getUsername();
        claimsMap.put("username", username);
        return Jwts.builder()
                .setSubject(username)
                .addClaims(claimsMap)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token);
            return true;
        }catch (SignatureException |
                MalformedJwtException |
                ExpiredJwtException |
                UnsupportedJwtException |
                IllegalArgumentException ex) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET)
                .parseClaimsJws(token)
                .getBody();
        String username = (String) claims.get("username");
        return username;
    }
}