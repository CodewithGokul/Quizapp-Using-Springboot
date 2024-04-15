// package com.example.gokul.Quizapp.services;

// import java.security.Key;
// import java.util.Date;
// import java.util.Base64.Decoder;
// import java.util.function.Function;

// import javax.crypto.SecretKey;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import com.example.gokul.Quizapp.models.Users;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Service
// public class jwtService {

//     private final static String SECRET_KEY = "4a11bea47e52e0d082dfd588098685d61c3b7cda639f26b2ef361f30e91b80e9";

//     private static Claims extractAllClaims(String token) {
//         return Jwts
//                 .parser()
//                 .verifyWith(getSigninKey())
//                 .build()
//                 .parseSignedClaims(token)
//                 .getPayload();
//     }

//     public static <T> T extractClaim(String token, Function<Claims, T> resolver) {
//         Claims claims = extractAllClaims(token);
//         return resolver.apply(claims);
//     }

//     public static String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public boolean isValid(String token, UserDetails user) {
//         String Username = extractUsername(token);
//         return Username.equals(user.getUsername()) && !isTokenExpired(token);
//     }

//     private boolean isTokenExpired(String token) {
//         return ExtractExpiration(token).before(new Date());
//     }

//     private Date ExtractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     public String generateToken(Users user) {
//         String token = Jwts
//                 .builder()
//                 .subject(user.getUsername())
//                 .issuedAt(new Date(System.currentTimeMillis()))
//                 .expiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
//                 .signWith(getSigninKey())
//                 .compact();
//         return token;
//     }

//     private static SecretKey getSigninKey() {

//         byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

// }