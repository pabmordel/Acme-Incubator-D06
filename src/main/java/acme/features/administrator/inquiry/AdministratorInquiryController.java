
package acme.features.administrator.inquiry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.inquiry.Inquiry;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/inquiry/")

public class AdministratorInquiryController extends AbstractController<Administrator, Inquiry> {

	@Autowired
	private AdministratorInquiryCreateService	createService;

	@Autowired
	private AdministratorInquiryUpdateService	updateService;

	@Autowired
	private AdministratorInquiryDeleteService	deleteService;

	@Autowired
	private AdministratorInquiryListService		listService;

	@Autowired
	private AdministratorInquiryShowService		showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
