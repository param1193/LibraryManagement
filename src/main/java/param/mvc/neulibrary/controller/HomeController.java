package param.mvc.neulibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import param.mvc.neulibrary.model.user.User;
import param.mvc.neulibrary.service.author.AuthorService;
import param.mvc.neulibrary.service.book.BookService;
import param.mvc.neulibrary.service.user.UserService;
import param.mvc.neulibrary.util.CommonAttributesPopulator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@Autowired
	AuthorService authorService;

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	// Simply selects the home view to render by returning its name.
	@RequestMapping(value = { "/" })
	public String home(@AuthenticationPrincipal UserDetails user, ModelMap model) {
		model.addAttribute("logged", false);

		if (user != null) {
			User currentUser = userService.findByUsername(user.getUsername());
			
			model.addAttribute("logged", true);
			CommonAttributesPopulator.populate(currentUser, model);
		}

		int authorsCount = authorService.findAllAuthors().size();
		int booksCount = bookService.findAllBooks().size();
		int usersCount = userService.findAllUsers().size();

		model.addAttribute("authorsCount", authorsCount);
		model.addAttribute("booksCount", booksCount);
		model.addAttribute("usersCount", usersCount);

		return "home";
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model, @AuthenticationPrincipal UserDetails userDetails) {
		User currentUser = userService.findByUsername(userDetails.getUsername());

		model.addAttribute("username", currentUser.getUsername());

		CommonAttributesPopulator.populate(currentUser, model);

		return "commons/accessDenied";
	}
}
