package org.winners.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.winners.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	@Query("select o from Compte o where o.login=:login and o.password = :password or o.email=:login and o.password = :password")
	public Compte getCompteByCredential(@Param("login") String login, @Param("password") String password);

}
