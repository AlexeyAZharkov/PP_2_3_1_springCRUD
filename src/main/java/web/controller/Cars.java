package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Cars {

	@GetMapping(value = "/cars")
	public String carPage(@RequestParam(value = "count", required = false) Integer count,
						  Model model) {
		Car car1 = new Car("Vesta", 2022, 11000);
		Car car2 = new Car("Granta", 2021, 9000);
		Car car3 = new Car("Logan", 2018, 12000);
		Car car4 = new Car("SX4", 2014, 14000);
		Car car5 = new Car("Duster", 2020, 15000);

		List<Car> messages = new ArrayList<>();
		messages.add(car1);
		messages.add(car2);
		messages.add(car3);
		messages.add(car4);
		messages.add(car5);


//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("carCount", "Count = " + count);
//		System.out.println("Count = " + count);
		return "cars";
	}
	
}