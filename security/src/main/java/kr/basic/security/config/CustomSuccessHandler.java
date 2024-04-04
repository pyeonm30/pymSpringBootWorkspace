package kr.basic.security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import kr.basic.security.config.auth.PrincipalDetails;
import kr.basic.security.entity.Users;
import kr.basic.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class CustomSuccessHandler  implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        PrincipalDetails principalDetails = (PrincipalDetails)oAuth2User;
        System.out.println("oAuth2User = " + oAuth2User);
        System.out.println("principalDetails = " + principalDetails);
        Users u = principalDetails.getUser();
        System.out.println("u = " + u);
        System.out.println("principalId = " + u.getProvider());
        System.out.println("principalId = " + u.getProviderId());
        response.sendRedirect("/test/oauth");


    }

}
