package com.example.Eidiko.Mail.Sender.service;

import com.example.Eidiko.Mail.Sender.model.Info;
import com.example.Eidiko.Mail.Sender.model.InfoPrincipal;
import com.example.Eidiko.Mail.Sender.repo.InfoRespository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private InfoRespository infoRespository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Info info = infoRespository.findByUsername(username);
        if (info == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new InfoPrincipal(info);
    }
}
