package com.example.my_fit.services.user;

import com.example.my_fit.model.entity.Role;
import com.example.my_fit.model.entity.User;
import com.example.my_fit.model.view.UserRegisterRequestModel;
import com.example.my_fit.repositories.RoleRepository;
import com.example.my_fit.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(UserRegisterRequestModel model) {
        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(
                this.passwordEncoder.encode(model.getPassword())
        );

        Role role = this.roleRepository.findFirstByName("USER");
        role.getUsers().add(user);
        user.getRoles().add(role);

        this.roleRepository.save(role);
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findFirstByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> roles = user.getRoles()
                .stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName()))
                .collect(Collectors.toSet());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles
        );

        return userDetails;
    }

   public User findUserEntityById(Long id) {
        return this.userRepository.findFirstById(id);
    }
}
