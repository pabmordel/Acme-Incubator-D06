
package acme.features.entrepreneur.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.application.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/application/")

public class EntrepreneurApplicationController extends AbstractController<Entrepreneur, Application> {

	@Autowired
	private EntrepreneurApplicationListService			listService;

	@Autowired
	private EntrepreneurApplicationShowService			showService;

	@Autowired
	private EntrepreneurApplicationListByTicketService	listByTicketService;

	@Autowired
	private EntrepreneurApplicationListByDateService	listByDateService;

	@Autowired
	private EntrepreneurApplicationUpdateService		updateService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LISTTICKET, BasicCommand.LIST, this.listByTicketService);
		super.addCustomCommand(CustomCommand.LISTDATE, BasicCommand.LIST, this.listByDateService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
