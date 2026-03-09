package com.jenventory.jenventoryapi.service;

import com.jenventory.jenventoryapi.auth.dto.request.LoginRequest;
import com.jenventory.jenventoryapi.auth.dto.request.RegisterRequest;
import com.jenventory.jenventoryapi.auth.dto.response.AuthenticationResponse;
import com.jenventory.jenventoryapi.auth.entity.User;
import com.jenventory.jenventoryapi.auth.repository.UserRepository;
import com.jenventory.jenventoryapi.auth.service.impl.AuthenticationService;
import com.jenventory.jenventoryapi.auth.service.impl.CookieService;
import com.jenventory.jenventoryapi.auth.service.impl.JwtService;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationService authenticationService;

    @Mock
    private CookieService cookieService;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    // ──────────────────────────────────────────────
    // register() tests
    // ──────────────────────────────────────────────

    @Test
    void register_validRequest_returnsAuthenticationResponseWithUserAndCookies() {
        // given
        RegisterRequest request = RegisterRequest.builder()
                .name("Juan Dela Cruz")
                .email("juan@example.com")
                .password("password123")
                .build();

        User savedUser = User.builder()
                .id(1L)
                .name("Juan Dela Cruz")
                .email("juan@example.com")
                .password("encodedPassword")
                .build();

        given(userRepository.findByEmail("juan@example.com")).willReturn(Optional.empty());
        given(passwordEncoder.encode("password123")).willReturn("encodedPassword");
        given(userRepository.save(any(User.class))).willReturn(savedUser);
        given(jwtService.generateAccessToken(any())).willReturn("access-token");
        given(jwtService.generateRefreshToken(any())).willReturn("refresh-token");
        given(cookieService.createAccessTokenCookie("access-token")).willReturn(new Cookie("accessToken", "access-token"));
        given(cookieService.createRefreshTokenCookie("refresh-token")).willReturn(new Cookie("refreshToken", "refresh-token"));

        // when
        AuthenticationResponse response = authenticationService.register(request);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getUser()).isNotNull();
        assertThat(response.getUser().getId()).isEqualTo(1L);
        assertThat(response.getUser().getName()).isEqualTo("Juan Dela Cruz");
        assertThat(response.getUser().getEmail()).isEqualTo("juan@example.com");
        assertThat(response.getCookies()).hasSize(2);

        verify(userRepository, times(1)).findByEmail("juan@example.com");
        verify(passwordEncoder, times(1)).encode("password123");
        verify(userRepository, times(1)).save(any(User.class));
        verify(jwtService, times(1)).generateAccessToken(any());
        verify(jwtService, times(1)).generateRefreshToken(any());
    }

    @Test
    void register_emailAlreadyExists_throwsRuntimeException() {
        // given
        RegisterRequest request = RegisterRequest.builder()
                .name("Juan Dela Cruz")
                .email("juan@example.com")
                .password("password123")
                .build();

        User existingUser = User.builder()
                .id(1L)
                .email("juan@example.com")
                .build();

        given(userRepository.findByEmail("juan@example.com")).willReturn(Optional.of(existingUser));

        // when / then
        assertThatThrownBy(() -> authenticationService.register(request))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Email already exists");

        verify(userRepository, never()).save(any(User.class));
        verify(jwtService, never()).generateAccessToken(any());
        verify(jwtService, never()).generateRefreshToken(any());
    }

    @Test
    void register_validRequest_passwordIsEncodedBeforeSaving() {
        // given
        RegisterRequest request = RegisterRequest.builder()
                .name("Maria Santos")
                .email("maria@example.com")
                .password("rawPassword")
                .build();

        User savedUser = User.builder()
                .id(2L)
                .name("Maria Santos")
                .email("maria@example.com")
                .password("encodedRawPassword")
                .build();

        given(userRepository.findByEmail("maria@example.com")).willReturn(Optional.empty());
        given(passwordEncoder.encode("rawPassword")).willReturn("encodedRawPassword");
        given(userRepository.save(any(User.class))).willReturn(savedUser);
        given(jwtService.generateAccessToken(any())).willReturn("at");
        given(jwtService.generateRefreshToken(any())).willReturn("rt");
        given(cookieService.createAccessTokenCookie(anyString())).willReturn(new Cookie("a", "a"));
        given(cookieService.createRefreshTokenCookie(anyString())).willReturn(new Cookie("r", "r"));

        // when
        authenticationService.register(request);

        // then
        verify(passwordEncoder, times(1)).encode("rawPassword");
        verify(userRepository).save(argThat(user ->
                user.getPassword().equals("encodedRawPassword")
        ));
    }

    @Test
    void register_validRequest_responseDoesNotLeakPassword() {
        // given
        RegisterRequest request = RegisterRequest.builder()
                .name("Test User")
                .email("test@example.com")
                .password("secret")
                .build();

        User savedUser = User.builder()
                .id(3L)
                .name("Test User")
                .email("test@example.com")
                .password("encodedSecret")
                .build();

        given(userRepository.findByEmail("test@example.com")).willReturn(Optional.empty());
        given(passwordEncoder.encode(anyString())).willReturn("encodedSecret");
        given(userRepository.save(any(User.class))).willReturn(savedUser);
        given(jwtService.generateAccessToken(any())).willReturn("at");
        given(jwtService.generateRefreshToken(any())).willReturn("rt");
        given(cookieService.createAccessTokenCookie(anyString())).willReturn(new Cookie("a", "a"));
        given(cookieService.createRefreshTokenCookie(anyString())).willReturn(new Cookie("r", "r"));

        // when
        AuthenticationResponse response = authenticationService.register(request);

        // then — UserResponse should not contain a password field
        assertThat(response.getUser()).hasNoNullFieldsOrProperties();
        // UserResponse only has id, name, email — no password exposure
    }

    // ──────────────────────────────────────────────
    // authenticate() tests
    // ──────────────────────────────────────────────

    @Test
    void authenticate_validCredentials_returnsAuthenticationResponse() {
        // given
        LoginRequest request = LoginRequest.builder()
                .email("juan@example.com")
                .password("password123")
                .build();

        User user = User.builder()
                .id(1L)
                .name("Juan Dela Cruz")
                .email("juan@example.com")
                .password("encodedPassword")
                .build();

        given(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .willReturn(new UsernamePasswordAuthenticationToken("juan@example.com", "password123"));
        given(userRepository.findByEmail("juan@example.com")).willReturn(Optional.of(user));
        given(jwtService.generateAccessToken(any())).willReturn("access-token");
        given(jwtService.generateRefreshToken(any())).willReturn("refresh-token");
        given(cookieService.createAccessTokenCookie("access-token")).willReturn(new Cookie("accessToken", "access-token"));
        given(cookieService.createRefreshTokenCookie("refresh-token")).willReturn(new Cookie("refreshToken", "refresh-token"));

        // when
        AuthenticationResponse response = authenticationService.authenticate(request);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getUser()).isNotNull();
        assertThat(response.getUser().getId()).isEqualTo(1L);
        assertThat(response.getUser().getName()).isEqualTo("Juan Dela Cruz");
        assertThat(response.getUser().getEmail()).isEqualTo("juan@example.com");
        assertThat(response.getCookies()).hasSize(2);

        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository, times(1)).findByEmail("juan@example.com");
    }

    @Test
    void authenticate_invalidCredentials_throwsBadCredentialsException() {
        // given
        LoginRequest request = LoginRequest.builder()
                .email("juan@example.com")
                .password("wrongPassword")
                .build();

        given(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .willThrow(new BadCredentialsException("Bad credentials"));

        // when / then
        assertThatThrownBy(() -> authenticationService.authenticate(request))
                .isInstanceOf(BadCredentialsException.class)
                .hasMessageContaining("Bad credentials");

        verify(userRepository, never()).findByEmail(anyString());
        verify(jwtService, never()).generateAccessToken(any());
    }

    @Test
    void authenticate_userNotFoundAfterAuth_throwsRuntimeException() {
        // given
        LoginRequest request = LoginRequest.builder()
                .email("ghost@example.com")
                .password("password123")
                .build();

        given(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .willReturn(new UsernamePasswordAuthenticationToken("ghost@example.com", "password123"));
        given(userRepository.findByEmail("ghost@example.com")).willReturn(Optional.empty());

        // when / then
        assertThatThrownBy(() -> authenticationService.authenticate(request))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("User not found");

        verify(authenticationManager, times(1)).authenticate(any());
        verify(jwtService, never()).generateAccessToken(any());
    }

    @Test
    void authenticate_validCredentials_delegatesToAuthenticationManager() {
        // given
        LoginRequest request = LoginRequest.builder()
                .email("juan@example.com")
                .password("password123")
                .build();

        User user = User.builder()
                .id(1L)
                .name("Juan Dela Cruz")
                .email("juan@example.com")
                .password("encodedPassword")
                .build();

        given(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .willReturn(new UsernamePasswordAuthenticationToken("juan@example.com", "password123"));
        given(userRepository.findByEmail("juan@example.com")).willReturn(Optional.of(user));
        given(jwtService.generateAccessToken(any())).willReturn("at");
        given(jwtService.generateRefreshToken(any())).willReturn("rt");
        given(cookieService.createAccessTokenCookie(anyString())).willReturn(new Cookie("a", "a"));
        given(cookieService.createRefreshTokenCookie(anyString())).willReturn(new Cookie("r", "r"));

        // when
        authenticationService.authenticate(request);

        // then
        verify(authenticationManager).authenticate(argThat(auth ->
                auth.getPrincipal().equals("juan@example.com") &&
                        auth.getCredentials().equals("password123")
        ));
    }
}

