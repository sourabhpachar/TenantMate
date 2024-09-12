package com.TenantMate.Repository;

import com.TenantMate.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String emailId);

}
