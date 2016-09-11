package org.winners.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.winners.dao.CompteRepository;
import org.winners.entities.Compte;
import org.winners.enumerations.Activity;
import org.winners.enumerations.Visiblite;

@Service
public class CompteMetierImpl implements CompteMetier {

	@Autowired
	CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte compte) {
		compte.setCreated(new Date());
		compte.setVisiblite(Visiblite.EN_LIGNE);
		compte.setActivity(Activity.NOT_MODERATE);
		return this.compteRepository.save(compte);
	}

	@Override
	public Compte getCompte(Long idCompte) {
		return this.compteRepository.findOne(idCompte);
	}

	@Override
	public List<Compte> allComptes() {
		return this.compteRepository.findAll();
	}

	@Override
	public Compte getCompteByCredential(String login, String password) {
		return this.compteRepository.getCompteByCredential(login, password);
	}

	@Override
	public Compte updateCompte(Compte compte) {
		return this.compteRepository.saveAndFlush(compte);
	}

	@Override
	@Transactional
	public Compte disableCompte(Long idCompte) {
		Compte compte = this.compteRepository.findOne(idCompte);
		compte.setActivity(Activity.DESACTIVE);
		return this.compteRepository.saveAndFlush(compte);
	}

	@Override
	public Compte activateCompte(Long idCompte) {
		Compte compte = this.compteRepository.findOne(idCompte);
		compte.setActivity(Activity.ACTIVE);
		return this.compteRepository.saveAndFlush(compte);
	}

	@Override
	public Boolean deleteCompte(Long idCompte) {
		this.compteRepository.delete(idCompte);
		return true;
	}

	@Override
	public Boolean deleteAllComptes() {
		this.compteRepository.deleteAllInBatch();
		return true;
	}

}
