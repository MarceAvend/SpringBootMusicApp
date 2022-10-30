package com.integrationproject.musicapp.repository;

import com.integrationproject.musicapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findAll();

    @Query(value = "SELECT u FROM AppUser u WHERE u.id =:aId")
    Optional<AppUser> findById(Long aId);
}
