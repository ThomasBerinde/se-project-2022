package com.example.seproject2022.repository;

import com.example.seproject2022.model.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

        Account findByEmail(String email);

        @Transactional
        void deleteAccountsByEmailStartsWith(String emailPrefix);
}
