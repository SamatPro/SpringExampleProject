package ru.study.spring.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.study.spring.repository.UserRepository;
import ru.study.spring.security.authentication.JwtAuthentication;
import ru.study.spring.security.details.UserDetailsImpl;
import ru.study.spring.security.details.UserDetailsServiceImpl;
import ru.study.spring.security.provider.JwtProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwt = request.getHeader("Auth");

        if (jwtProvider.validateToken(jwt)) {
            String username = jwtProvider.getUsernameFromJwt(jwt);

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            JwtAuthentication jwtAuthentication = new JwtAuthentication(jwt);

            jwtAuthentication.setAuthenticated(true);
            jwtAuthentication.setUserDetails((UserDetailsImpl) userDetails);

            SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);

        }

        filterChain.doFilter(request, response);
    }
}
