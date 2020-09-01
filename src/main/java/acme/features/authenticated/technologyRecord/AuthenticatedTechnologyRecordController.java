
package acme.features.authenticated.technologyRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.technologyRecord.TechnologyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/technology-record/")

public class AuthenticatedTechnologyRecordController extends AbstractController<Authenticated, TechnologyRecord> {

	@Autowired
	private AuthenticatedTechnologyRecordListByStarsService		listByStarsService;

	@Autowired
	private AuthenticatedTechnologyRecordListBySectorService	listBySectorService;

	@Autowired
	private AuthenticatedTechnologyRecordShowService			showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LISTSTARS, BasicCommand.LIST, this.listByStarsService);
		super.addCustomCommand(CustomCommand.LISTSECTOR, BasicCommand.LIST, this.listBySectorService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
