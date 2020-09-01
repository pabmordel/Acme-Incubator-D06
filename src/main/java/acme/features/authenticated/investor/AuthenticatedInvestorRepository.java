
package acme.features.authenticated.investor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import acme.entities.roles.Investor;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Service
public interface AuthenticatedInvestorRepository extends AbstractRepository {

	@Query("select n from Investor n where n.userAccount.id = ?1")
	Investor findInvestorByUserId(int id);

	@Query("select n from UserAccount n where n.id = ?1")
	UserAccount findOneUserAccountById(int id);

}
