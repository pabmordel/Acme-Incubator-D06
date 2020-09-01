
package acme.features.authenticated.entrepreneur;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import acme.entities.roles.Entrepreneur;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Service
public interface AuthenticatedEntrepreneurRepository extends AbstractRepository {

	@Query("select n from Entrepreneur n where n.userAccount.id = ?1")
	Entrepreneur findEntrepreneurByUserId(int id);

	@Query("select n from UserAccount n where n.id = ?1")
	UserAccount findOneUserAccountById(int id);

}
