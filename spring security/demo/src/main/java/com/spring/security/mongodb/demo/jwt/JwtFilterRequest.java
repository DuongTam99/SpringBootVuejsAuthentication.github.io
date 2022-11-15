package com.spring.security.mongodb.demo.jwt;


import com.spring.security.mongodb.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    //Filterchain la bộ lọc khi mot request den sever can duoc bo loc thuc thi
     //check jwt.xác thực bằng việc parsing JWT và kiểm tra các thuộc tính.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//check header
        String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        //kiem tra authorizationHeader khong null va phai dbat dau bang
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwtToken = authorizationHeader.substring(7);
            username = jwtUtils.extractUsername(jwtToken);
        }
          //kiem tra user name ko duoc null va nguoi dung ngu canh phai la null
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails currentUserDetails = userDetailsServiceImpl.loadUserByUsername(username);
            Boolean tokenValidated = jwtUtils.validateToken(jwtToken, currentUserDetails);
            if (tokenValidated) {
                // xay dung mat khau token xac thuc nguoi dung
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(currentUserDetails, null, currentUserDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(request, response);

    }
}
