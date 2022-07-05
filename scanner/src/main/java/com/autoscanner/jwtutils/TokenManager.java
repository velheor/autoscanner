//
//package by.grsu.jwtutils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Objects;
//
//@Component
//public class TokenManager implements Serializable {
//    private static final long serialVersionUID = 7008375124389347049L;
//    public static final long TOKEN_VALIDITY = 10 * 60 * 60;
//    @Value("${secret}")
//    private String jwtSecret;
//
//    public String generateJwtToken(final UserDetails userDetails) {
//        return Jwts.builder()
//                .setClaims(new HashMap<>())
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
//
//    public Boolean isValidJwtToken(final String token, final UserDetails userDetails) {
//        final Claims claims = getClaims(token);
//        final String username = claims.getSubject();
//        return Objects.equals(username, userDetails.getUsername()) && !isTokenExpired(claims);
//    }
//
//    private boolean isTokenExpired(final Claims claims) {
//        return claims
//                .getExpiration()
//                .before(new Date());
//    }
//
//    private Claims getClaims(final String token) {
//        return Jwts.parser()
//                .setSigningKey(jwtSecret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String getUsernameFromToken(final String token) {
//        return getClaims(token).getSubject();
//    }
//}
