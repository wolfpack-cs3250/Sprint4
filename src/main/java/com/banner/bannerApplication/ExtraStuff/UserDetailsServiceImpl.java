package com.banner.bannerApplication.ExtraStuff;


import com.banner.bannerApplication.entities.Position;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.*;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly= true)
    public UserDetails loadbyUsername(String username) throws UsernameNotFoundException{
        User user= userRepository.findByUsername(username);
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    for (Position position : user.getPositions()){
        grantedAuthorities.add(new SimpleGrantedAuthority(position.getName()));
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), grantedAuthorities);
    }
}
