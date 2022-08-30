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
//	private final UserDao userDaoImp;
	private final UserService userServiceImp;

	public Users(UserService userServiceImp) {
//		this.userDaoImp = userDaoImp;
		this.userServiceImp = userServiceImp;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		return "index";
	}

	@GetMapping(value = "/set3users")
	public String set3users(ModelMap model) {
		userServiceImp.addUser(new User("Alex", "Zh", "axx@uu"));
		userServiceImp.addUser(new User("Alex1", "Zh1", "ax11x@uu"));
		userServiceImp.addUser(new User("Alex2", "Zh2", "ax22x@uu"));
		return "redirect:/users";
	}


	@GetMapping(value = "/users")
	public String userPage(Model model) {
		model.addAttribute("allUsers", userServiceImp.listUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping("/new")
	public String create(@ModelAttribute("user") User user) {
		userServiceImp.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
		userServiceImp.deleteUser(id);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam(value = "id", required = false) Long id, Model model) {
		model.addAttribute("user", userServiceImp.getUserById(id));
		return "edit";
	}

	@PostMapping("/updateuser/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userServiceImp.updateUser(id, user);
		return "redirect:/users";
	}


//	@GetMapping("users/{id}")
//	public String showUser(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("userbyid", userDaoImp.getUserById(id));
////		model.addAttribute("user1", userDaoImp.getUserById(id).getEmail());
////		System.out.println(1122);
//		return "show";
//	}

}