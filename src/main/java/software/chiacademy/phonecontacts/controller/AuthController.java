//package software.chiacademy.phonecontacts.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//import software.chiacademy.phonecontacts.dao.RoleDAO;
//import software.chiacademy.phonecontacts.dao.UserDAO;
//import software.chiacademy.phonecontacts.dto.LoginDto;
//import software.chiacademy.phonecontacts.dto.SignUpDto;
//import software.chiacademy.phonecontacts.model.Contact;
//import software.chiacademy.phonecontacts.model.Role;
//
//import java.util.Collections;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserDAO userRepository;
//
//    @Autowired
//    private RoleDAO roleRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginDto.getName(), loginDto.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){
//
//        if(userRepository.existsByName(signUpDto.getName())){
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
//        }
//
//
//        Contact user = new Contact();
//        user.setName(signUpDto.getName());
//        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//
//        Role roles = roleRepository.findByName("ROLE_USER").get();
//        user.setRoles(Collections.singleton(roles));
//
//        userRepository.save(user);
//
//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
//    }
//}