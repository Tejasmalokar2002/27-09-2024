package com.example.Eidiko.Mail.Sender.repo;

import com.example.Eidiko.Mail.Sender.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRespository extends JpaRepository<Info, Integer> {

    Info findByUsername(String username);
}
