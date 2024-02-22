package com.roccatagliatta.restaurant.User.Application.UseCase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.roccatagliatta.restaurant.Security.JwtUtils;
import com.roccatagliatta.restaurant.Security.UserDetailsImpl;
import com.roccatagliatta.restaurant.User.Application.UseCase.Exception.SignInUseCaseException;
import com.roccatagliatta.restaurant.User.Infrastructure.SignInRequest;

import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public final class SignInUseCase {

    private AuthenticationManager authenticationManager;

    private JwtUtils jwtUtils;

    public SignInUseCase(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public void run(SignInRequest request, Map<String, Object> response)
            throws SignInUseCaseException {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.username(),
                            request.password()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            response.put("id", userDetails.getId());
            response.put("username", userDetails.getUsername());
            response.put("email", userDetails.getEmail());
            response.put("roles", roles);
            response.put("jwtCookie", jwtCookie.toString()); // XXX: nasty hack

        } catch (final AuthenticationException ex) {
            throw SignInUseCaseException.badCredentials();
        }

    }
}
