package com.example.Eidiko.Mail.Sender.service;

import com.example.Eidiko.Mail.Sender.model.Info;
import com.example.Eidiko.Mail.Sender.repo.InfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private InfoRespository infoRespository;

    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Info register(Info info){
        info.setPassword(encoder.encode(info.getPassword()));
         infoRespository.save(info);
         return info;
    }

public String verify(Info info){
    Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(info.getUsername(), info.getPassword()));
if(authentication.isAuthenticated()) {
    return jwtService.generateToken(info.getUsername());
}
else{
return "fail";
    }
}
}
