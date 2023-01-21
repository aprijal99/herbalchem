package org.herbal.chem.authorization.service;

import lombok.AllArgsConstructor;
import org.herbal.chem.authorization.entity.UserAccountEntity;
import org.herbal.chem.authorization.repository.UserAccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService, UserDetailsService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUserAccount(UserAccountEntity userAccountEntity) {
        userAccountEntity.setPassword(passwordEncoder.encode(userAccountEntity.getPassword()));
        userAccountRepository.save(userAccountEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccountEntity userAccountEntity = userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User account not found"));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userAccountEntity.getRole());

        return User.withUsername(username)
                .password(userAccountEntity.getPassword())
                .authorities(authority)
                .build();
    }
}
