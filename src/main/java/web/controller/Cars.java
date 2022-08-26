package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;


@Controller
public class Cars {

	@GetMapping(value = "/cars")
	public String carPage(@RequestParam(value = "count", required = false) Integer count,
						  Model model) {

		CarServiceImp carServiceImp = new CarServiceImp();

		carServiceImp.addCar(new Car("Vesta", 2022, 11000));
		carServiceImp.addCar(new Car("Granta", 2021, 9000));
		carServiceImp.addCar(new Car("Logan", 2018, 12000));
		carServiceImp.addCar(new Car("SX4", 2014, 14000));
		carServiceImp.addCar(new Car("Duster", 2020, 15000));

		if (count == null || count > 5) {
			count = 5;
		}

		model.addAttribute("carsForShow", carServiceImp.listCarsFromRequest(count));

		return "cars";
	}
	
}