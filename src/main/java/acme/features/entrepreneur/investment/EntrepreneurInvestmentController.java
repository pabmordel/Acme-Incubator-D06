
package acme.features.entrepreneur.investment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/investment/")

public class EntrepreneurInvestmentController extends AbstractController<Entrepreneur, Investment> {

	@Autowired
	private EntrepreneurInvestmentListService	listService;

	@Autowired
	private EntrepreneurInvestmentShowService	showService;

	@Autowired
	private EntrepreneurInvestmentCreateService	createService;

	@Autowired
	private EntrepreneurInvestmentDeleteService	deleteService;

	@Autowired
	private EntrepreneurInvestmentUpdateService	updateService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);

	}

}
