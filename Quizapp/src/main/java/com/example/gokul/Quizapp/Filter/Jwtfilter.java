// package com.example.gokul.Quizapp.Filter;

// import java.io.IOException;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.example.gokul.Quizapp.models.Users;
// import com.example.gokul.Quizapp.services.jwtService;
// import com.example.gokul.Quizapp.services.userServices;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// public class Jwtfilter extends OncePerRequestFilter {

//     private jwtService jwtservice;
//     private userServices userservice;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         String authHeader = request.getHeader("Authorization");

//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String token = authHeader.substring(7);
//         String username = jwtservice.extractUsername(token);

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             UserDetails users = userservice.loadUserByUsername(username);

//             if (jwtservice.isValid(token, users)) {

//                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(users, null,
//                         users.getAuthorities());
//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }
