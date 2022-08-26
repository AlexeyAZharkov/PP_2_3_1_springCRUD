package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Cars {

	@GetMapping(value = "/cars")
	public String carPage(@RequestParam(value = "count", required = false) Integer count ) {
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");
//		model.addAttribute("messages", messages);
		System.out.println("Count = " + count);
		return "cars";
	}
	
}