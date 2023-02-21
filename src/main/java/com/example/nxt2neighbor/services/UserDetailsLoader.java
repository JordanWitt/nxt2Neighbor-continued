package com.example.nxt2neighbor.services;


import com.example.nxt2neighbor.models.UserWithRoles;
import com.example.nxt2neighbor.models.Users;
import com.example.nxt2neighbor.repositories.ListingRepository;
import com.example.nxt2neighbor.repositories.RoleRepository;
import com.example.nxt2neighbor.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository rolesRepository;
    private final ListingRepository listingRepository;

    public UserDetailsLoader(UserRepository userRepository, RoleRepository rolesRepository, ListingRepository listingRepository) {
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWithRoles(user);
    }
}