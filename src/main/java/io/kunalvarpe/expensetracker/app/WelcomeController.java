package io.kunalvarpe.expensetracker.app;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("userName", "Kunal Varpe");
		model.addAttribute("userId", 1);
		return "index";
	}

}
