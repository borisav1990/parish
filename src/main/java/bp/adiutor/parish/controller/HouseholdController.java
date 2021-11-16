package bp.adiutor.parish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bp.adiutor.parish.model.Household;
import bp.adiutor.parish.model.Street;
import bp.adiutor.parish.service.HouseholdService;
import bp.adiutor.parish.service.PatronService;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.StreetService;


@Controller
@RequestMapping("/user/household")
public class HouseholdController {
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private PatronService patronService;
	
	@Autowired
	private RectoryService rectoryService;
	
	@Autowired
	private StreetService streetService;
	
	
	@RequestMapping("/view")
	public String view(Model model) {
        model.addAttribute("householdsList", householdService.getHouseholdByRectory());
        model.addAttribute("streetsList", streetService.getAllStreetByRectory());
		model.addAttribute("rectory", rectoryService.getRectoryByUser());
		model.addAttribute("household", new Household());
		model.addAttribute("patrons", patronService.getAllPatron());
	
		return "households/household_index";
	}
	
	

}
