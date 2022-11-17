package com.candidate.repo;


import com.candidate.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<ApplicationUser,Long> {
    ApplicationUser findByUsernameAndPassword(String username, String password);
}
