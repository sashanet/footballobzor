package com.footballobzor.demo.config.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.footballobzor.demo.persistance.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {


    JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(SecurityConstants.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }

        CustomAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    /*This method reads the JWT from the Authorization header,
     * and then uses Jwts to validate the token.
     * If everything is in place, we set the user in the SecurityContext and allow the request to move on.*/

    private CustomAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.HEADER_STRING);
        if (token != null) {

            ObjectMapper mapper = objectMapper();
            // parse the token.
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET.getBytes())
                    .parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""));

            UserEntity user =mapper.convertValue(claims.getHeader().get("principal"), UserEntity.class);

            String db = (String) claims.getBody()
                    .get("db");

            System.out.println("=======> Printing the User in the GetAuthentication: " + user);
            System.out.println("=======> Printing the Db in the GetAuthentication: " + db);

            if (user != null) {
                return new CustomAuthenticationToken(user, null, new ArrayList<>(), db);
            }
            return null;
        }
        return null;
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        return objectMapper;

    }
}
