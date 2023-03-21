package com.witnesses.web.repository;

import com.witnesses.web.entity.ConfirmToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmTokenRepository extends JpaRepository<ConfirmToken, String> {
    @Query
    Optional<ConfirmToken> findByToken(String token);

    @Query
    Optional<ConfirmToken> findByUser(String user);
}
