package bp.adiutor.parish.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import bp.adiutor.parish.model.Street;
import bp.adiutor.parish.service.CityService;
import bp.adiutor.parish.service.RectoryService;
import bp.adiutor.parish.service.StreetService;

@Controller
@RequestMapping("/user/street")
public class StreetController {
	
	@Autowired
	private StreetService streetService;
	
	@Autowired
	private RectoryService rectoryService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/view")
	public String view(Model model) {
        model.addAttribute("streetsList", streetService.getAllStreetByRectory());
		model.addAttribute("rectory", rectoryService.getRectoryByUser());
		model.addAttribute("street", new Street());
		model.addAttribute("cities", cityService.getAllCity());
		return "streets/street_index";
	}
	
	@PostMapping(value="/saveStreet")
	@ResponseBody
	public Street saveStreet(@RequestBody Street street) throws JsonProcessingException {
		Street s = streetService.createStreet(street);
	    return s;
	    }
	
	@GetMapping(value = "/delete")
	public String deleteStreet(@RequestParam Integer streetId) {
		streetService.deleteById(streetId);
		return "redirect:/user/street/view";
		}
	
}

   
