//package ru.study.spring.security.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//import ru.study.spring.model.Auth;
//import ru.study.spring.model.User;
//import ru.study.spring.repository.AuthRepository;
//import ru.study.spring.repository.UserRepository;
//import ru.study.spring.security.authentication.CookieAuthentication;
//import ru.study.spring.security.details.UserDetailsImpl;
//import ru.study.spring.security.details.UserDetailsServiceImpl;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Optional;
//
//public class CookieAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    @Qualifier("customUserDetailsService")
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        Cookie[] cookies = request.getCookies();
//
//        if (cookies != null) {
//            for (Cookie cookie: cookies) {
//                if (cookie.getName().equals("auth")) {
//
//                    Optional<User> userOptional = userRepository.findUserByCookieValue(cookie.getValue());
//
//                    if (userOptional.isPresent()) {
//                        User user = userOptional.get();
//
//                        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
//
//                        CookieAuthentication cookieAuthentication = new CookieAuthentication(cookie.getValue());
//
//                        cookieAuthentication.setUserDetails((UserDetailsImpl) userDetails);
//                        cookieAuthentication.setAuthenticated(true);
//
//                        SecurityContextHolder.getContext().setAuthentication(cookieAuthentication);
//                    }
//                }
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
