package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.ServiceCar;
import web.service.ServiceCarImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	ServiceCar serviceCar;

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping(value = "cars")
	public String printCar(@RequestParam(value = "count", required = false) Integer count, Model model) {
		List<Car> cars1 = serviceCar.findSome();
		List<Car> cars2 = new ArrayList<>();
		if (count != null) {
			if (count > 0 & count < 6) {
				for (int i = 0; i < count; i++) {
					cars2.add(cars1.get(i));
				}
				model.addAttribute("carFromServer", cars2);
			} else if (count > 5) {
				for (int i = 0; i < ServiceCarImpl.models.length; i++) {
					cars2.add(cars1.get(i));
				}
				model.addAttribute("carFromServer", cars2);
			}
		} else {
				for (int i = 0; i < ServiceCarImpl.models.length; i++) {
					cars2.add(cars1.get(i));
				}
				model.addAttribute("carFromServer", cars2);
			}
		return "cars";
	}
}