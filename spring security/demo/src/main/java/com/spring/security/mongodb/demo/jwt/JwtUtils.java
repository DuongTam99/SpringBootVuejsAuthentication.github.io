package com.spring.security.mongodb.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {
    private static final String SECRET_KEY = "secret1209cn389127b31c2927fb432937f42927f43827fb438";//may ma bi mat dung de bam ra thuat toan ma token

    //tao mot ma thong bao token, chung ta se can thong tin nguoi dung
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());

    }

    //xac thuc ma token
    public Boolean validateToken(String token, UserDetails userDetails) {
        String userName = extractUsername(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExprired(token);
    }
    //tao token claims la quyen so huu,jwts tim kiem,xac nhan quyen so huu ca duoc ban hanh tai setExpiration

    private String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date(System.currentTimeMillis());
        Date until = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);//khoan het han 10h
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(until).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        // compact JWT có thể được truyền đi thông qua URL, hoặc qua giao thức POST, hay gán vào bên trong phần HTTP Header.
        //ki ma token bang thuat toan
    }

    //cac phuong thuc trich xuat quyen so huu
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //kiem tra token het han hay chua
    private Boolean isTokenExprired(String token) {
        return extractExpiration(token).before(new Date());
    }

}
