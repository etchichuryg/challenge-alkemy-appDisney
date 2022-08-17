package com.alkemy.challenge.security.util;


import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

 
@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
     
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;
     
    @SuppressWarnings("deprecation")
	public String generateToken(UserDetails user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getUsername(), user.getPassword()))
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
                 
    }
    
    
    @SuppressWarnings("deprecation")
	public boolean validateAccessToken(String token) throws Exception {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
           throw new  Exception(ex);
        }
    }
     
    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }
     
    @SuppressWarnings("deprecation")
	private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

