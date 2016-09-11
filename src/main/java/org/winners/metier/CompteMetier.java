package org.winners.metier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.winners.entities.Compte;

@Service
public interface CompteMetier {
	Compte saveCompte(Compte compte);

	Compte getCompte(Long idCompte);

	List<Compte> allComptes();

	Compte getCompteByCredential(String login, String password);

	Compte updateCompte(Compte compte);

	Compte disableCompte(Long idCompte);

	Compte activateCompte(Long idCompte);

	Boolean deleteCompte(Long idCompte);

	Boolean deleteAllComptes();

}
