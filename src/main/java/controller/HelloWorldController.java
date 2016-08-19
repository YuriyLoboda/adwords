package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping
	public String helloWord(Model model){
		model.addAttribute("model", "Hello World");
		return "Hello World";
		
	}

}
