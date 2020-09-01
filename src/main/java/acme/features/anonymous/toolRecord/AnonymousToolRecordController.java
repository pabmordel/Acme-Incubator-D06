
package acme.features.anonymous.toolRecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.toolRecord.ToolRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/tool-record/")
public class AnonymousToolRecordController extends AbstractController<Anonymous, ToolRecord> {

	@Autowired
	private AnonymousToolRecordListByStarsService	listByStarsService;

	@Autowired
	private AnonymousToolRecordListBySectorService	listBySectorService;

	@Autowired
	private AnonymousToolRecordShowService			showService;


	//Constructors

	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LISTSTARS, BasicCommand.LIST, this.listByStarsService);
		super.addCustomCommand(CustomCommand.LISTSECTOR, BasicCommand.LIST, this.listBySectorService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
