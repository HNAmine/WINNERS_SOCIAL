package org.winners.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.winners.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
