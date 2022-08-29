package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;


@Controller
public class Users {
	private final UserDao userDaoImp;
	private final UserService userServiceImp;

	public Users(UserDao userDaoImp, UserService userServiceImp) {
		this.userDaoImp = userDaoImp;
		this.userServiceImp = userServiceImp;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		userDaoImp.addUser(new User("Alex", "Zh", "axx@uu"));
		userDaoImp.addUser(new User("Alex1", "Zh1", "ax11x@uu"));
		userDaoImp.addUser(new User("Alex2", "Zh2", "ax22x@uu"));
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC application");
//		messages.add("5.2.0 version by sep'19 ");
//		model.addAttribute("messages", messages);

//		model.addAttribute("allUsers", userDaoImp.listUsers());

		return "index";
	}


	@GetMapping(value = "/users")
	public String userPage(Model model) {
		model.addAttribute("allUsers", userDaoImp.listUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute("user") User user) {
		userDaoImp.addUser(user);
		return "redirect:/users";
	}

//	@PostMapping("/edituser")
//	public String edituser(@ModelAttribute("user") User user) {
//		userDaoImp.editUser(user);
//		return "redirect:/users";
//	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
		userServiceImp.deleteUser(id);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam(value = "id", required = false) Long id, Model model) {
		model.addAttribute("user", userDaoImp.listUsers());
		userServiceImp.editUser(id);
		return "edit";
	}

}