//
//package by.grsu.jwtutils;
//
//import by.grsu.service.user.UserDetailsServiceImpl;
//import io.jsonwebtoken.ExpiredJwtException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    private TokenManager tokenManager;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String tokenHeader = request.getHeader("Authorization");
//        String username = null;
//        String token = null;
//        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
//            token = tokenHeader.substring(7);
//            try {
//                username = tokenManager.getUsernameFromToken(token);
//            } catch (IllegalArgumentException e) {
//                log.error("Unable to get JWT Token");
//            } catch (ExpiredJwtException e) {
//                log.error("JWT Token has expired");
//            }
//        } else {
//            log.error("Bearer String not found in token");
//        }
//        if (null != username && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            if (tokenManager.isValidJwtToken(token, userDetails)) {
//                UsernamePasswordAuthenticationToken authenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}