package org.winners.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.winners.entities.Compte;
import org.winners.metier.CompteMetier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Compte Controller", description = "Compte description")
public class CompteRestService {

	@Autowired
	private CompteMetier compteMetier;

	@ApiOperation(value = "Save compte")
	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}

	@RequestMapping(value = "/comptes/{idCompte}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable Long idCompte) {
		return compteMetier.getCompte(idCompte);
	}

	@ApiOperation(value = "ALL comptes ;)")
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> allComptes() {
		return compteMetier.allComptes();
	}

	@RequestMapping(value = "/comptes/auth", method = RequestMethod.GET)
	public Compte getCompteByCredential(@RequestParam String login, @RequestParam String password) {
		return compteMetier.getCompteByCredential(login, password);
	}

	@RequestMapping(value = "/comptes", method = RequestMethod.PUT)
	public Compte updateCompte(@RequestBody Compte compte) {
		return compteMetier.updateCompte(compte);
	}

	@RequestMapping(value = "/comptes/disable/{idCompte}", method = RequestMethod.PUT)
	public Compte disableCompte(@PathVariable Long idCompte) {
		return compteMetier.disableCompte(idCompte);
	}

	@RequestMapping(value = "/comptes/activate/{idCompte}", method = RequestMethod.PUT)
	public Compte activateCompte(@PathVariable Long idCompte) {
		return compteMetier.activateCompte(idCompte);
	}

	@RequestMapping(value = "/comptes/{idCompte}", method = RequestMethod.DELETE)
	public Boolean deleteCompte(@PathVariable Long idCompte) {
		return compteMetier.deleteCompte(idCompte);
	}

	@RequestMapping(value = "/comptes", method = RequestMethod.DELETE)
	public Boolean deleteAllComptes() {
		return compteMetier.deleteAllComptes();
	}

}
