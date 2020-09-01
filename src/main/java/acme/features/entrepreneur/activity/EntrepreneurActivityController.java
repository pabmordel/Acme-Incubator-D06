
package acme.features.entrepreneur.activity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.activity.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/activity/")

public class EntrepreneurActivityController extends AbstractController<Entrepreneur, Activity> {

	@Autowired
	private EntrepreneurActivityListService		listService;

	@Autowired
	private EntrepreneurActivityShowService		showService;

	@Autowired
	private EntrepreneurActivityCreateService	createService;

	@Autowired
	private EntrepreneurActivityDeleteService	deleteService;

	@Autowired
	private EntrepreneurActivityUpdateService	updateService;


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
