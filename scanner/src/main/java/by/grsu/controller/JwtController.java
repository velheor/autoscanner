//
//package by.grsu.controller;
//
//import by.grsu.dto.JwtRequestDto;
//import by.grsu.dto.JwtResponseDto;
//import by.grsu.dto.UserDto;
//import by.grsu.jwtutils.TokenManager;
//import by.grsu.service.user.UserDetailsServiceImpl;
//import by.grsu.service.user.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//@RequiredArgsConstructor
//public class JwtController {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    private final UserService userService;
//    private final AuthenticationManager authenticationManager;
//    private final TokenManager tokenManager;
//
//    @PostMapping("login")
//    public ResponseEntity<JwtResponseDto> createToken(@RequestBody JwtRequestDto request) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        final String jwtToken = tokenManager.generateJwtToken(userDetails);
//        return ResponseEntity.ok(new JwtResponseDto(jwtToken));
//    }
//
//    @PostMapping("registration")
//    public HttpStatus registration(@RequestBody UserDto userDto) {
//        userService.registerNewUserAccount(userDto);
//        return HttpStatus.OK;
//    }
//}
