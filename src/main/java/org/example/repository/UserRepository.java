package org.example.repository;

import org.example.domain.user.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String login);


}
