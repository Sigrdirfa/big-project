package com.witnesses.web.repository;

import com.witnesses.web.entity.ConfirmToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConfirmTokenRepository extends JpaRepository<ConfirmToken, UUID> {
    @Query
    Optional<ConfirmToken> findByToken(String token);

    @Query
    Optional<ConfirmToken> findByUser(UUID user);
}
