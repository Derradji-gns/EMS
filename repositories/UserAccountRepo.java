package com.derradjiamine.Backend.repositories;

import com.derradjiamine.Backend.entities.UserAccount;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, UUID> {
    Optional<UserAccount> findOneByUsername(String username);

    @Query("""
              SELECT COUNT(u) >  From UserAccount u
               WHERE u.username = :username AND u.imployee.id = employeeId
            """
)
public boolean isOwner(@Param("username") UUID username , @Param("employeeId") UUID employeeId);

      }