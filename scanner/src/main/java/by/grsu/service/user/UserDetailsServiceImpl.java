//package by.grsu.service.user;
//
////import by.grsu.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(final String username) {
//        return userRepository.findByUsername(username)
//                .map(user -> new User(user.getUsername(), user.getPassword(), new ArrayList<>()))
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//    }
//
//}
