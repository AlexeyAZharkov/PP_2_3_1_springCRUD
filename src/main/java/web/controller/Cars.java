package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Cars {

	@GetMapping(value = "/cars")
	public String carPage(@RequestParam(value = "count", required = false) Integer count,
						  Model model) {
		StringBuilder messag = new StringBuilder();
		CarServiceImp carServiceImp = new CarServiceImp();

		Car car1 = new Car("Vesta", 2022, 11000);
		Car car2 = new Car("Granta", 2021, 9000);
		Car car3 = new Car("Logan", 2018, 12000);
		Car car4 = new Car("SX4", 2014, 14000);
		Car car5 = new Car("Duster", 2020, 15000);

		carServiceImp.addCar(car1);
		carServiceImp.addCar(car2);
		carServiceImp.addCar(car3);
		carServiceImp.addCar(car4);
		carServiceImp.addCar(car5);

		List<Car> messages = new ArrayList<>();
		messages.add(car1);
		messages.add(car2);
		messages.add(car3);
		messages.add(car4);
		messages.add(car5);

		if (count == null || count > 5) {
			count = 5;
		}
		System.out.println(count);

		List<Car> cars = carServiceImp.listCarsFromRequest(count);
		System.out.println(cars.get(0));
//		for (car : cars) {
//			System.out.println(car);
//		}


//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");

		for (int i = 0; i < count; i++) {
			messag.append(messages.get(i));
		}
		model.addAttribute("carCount", "Count = " + messag);
		model.addAttribute("carsForShow", cars);

//		System.out.println("Count = " + count);
		return "cars";
	}
	
}