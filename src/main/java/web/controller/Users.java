package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Users {
	private final UserDao userDaoImp;

	public Users(UserDao userDaoImp) {
		this.userDaoImp = userDaoImp;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");
//		model.addAttribute("messages", messages);

		model.addAttribute("allUsers", userDaoImp.listUsers());

		return "index";
	}


	@GetMapping(value = "/users")
	public String userPage(Model model) {
		userDaoImp.addUser(new User("Alex", "Zh", "axx@uu"));
		userDaoImp.addUser(new User("Alex1", "Zh1", "ax11x@uu"));
		userDaoImp.addUser(new User("Alex2", "Zh2", "ax22x@uu"));

//		CarServiceImp carServiceImp = new CarServiceImp();
//		carServiceImp.addCar(new Car("Vesta", 2022, 11000));
//		carServiceImp.addCar(new Car("Granta", 2021, 9000));
//		carServiceImp.addCar(new Car("Logan", 2018, 12000));
//		carServiceImp.addCar(new Car("SX4", 2014, 14000));
//		carServiceImp.addCar(new Car("Duster", 2020, 15000));

//		if (count == null || count > 5) {
//			count = 5;
//		}
		model.addAttribute("allUsers", userDaoImp.listUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userDaoImp.addUser(user);
		return "redirect:/users";
	}
	
}