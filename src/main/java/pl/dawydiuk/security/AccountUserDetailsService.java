package pl.dawydiuk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dawydiuk.model.Role;
import pl.dawydiuk.model.User;
import pl.dawydiuk.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Konrad on 30.10.2016.
 */
@Service
public class AccountUserDetailsService implements UserDetailsService{

    private UserService userService;

    @Autowired
    public AccountUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userByLogin = userService.findUserByLogin(s);
        if (userByLogin == null) return null;

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for(Role role:userByLogin.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        userByLogin.getLogin(),
                        userByLogin.getPassword(),
                        userByLogin.isEnabled(),
                        !userByLogin.isExpired(),
                        !userByLogin.isCredentialexpired(),
                        !userByLogin.isLocked(),
                        grantedAuthorities);

        return userDetails;
    }
}
