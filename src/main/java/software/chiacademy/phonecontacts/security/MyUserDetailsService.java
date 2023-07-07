//package software.chiacademy.phonecontacts.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import software.chiacademy.phonecontacts.dao.UserDAO;
//import software.chiacademy.phonecontacts.model.Contact;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    private UserDAO userRepository;
//
//    public MyUserDetailsService(UserDAO userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Contact user = userRepository.findByName(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username or email: "+ username));
//
//        Set<GrantedAuthority> authorities = user
//                .getRoles()
//                .stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
//
//        return new org.springframework.security.core.userdetails.User(user.getName(),
//                user.getPassword(),
//                authorities);
//    }
//}
