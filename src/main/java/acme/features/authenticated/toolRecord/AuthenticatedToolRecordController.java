
package acme.features.authenticated.toolRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.toolRecord.ToolRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/tool-record/")
public class AuthenticatedToolRecordController extends AbstractController<Authenticated, ToolRecord> {

	@Autowired
	private AuthenticatedToolRecordListByStarsService	listByStarsService;

	@Autowired
	private AuthenticatedToolRecordListBySectorService	listBySectorService;

	@Autowired
	private AuthenticatedToolRecordShowService			showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LISTSTARS, BasicCommand.LIST, this.listByStarsService);
		super.addCustomCommand(CustomCommand.LISTSECTOR, BasicCommand.LIST, this.listBySectorService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
