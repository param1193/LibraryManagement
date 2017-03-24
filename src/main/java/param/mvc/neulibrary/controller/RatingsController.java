package param.mvc.neulibrary.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import param.mvc.neulibrary.model.book.Book;
import param.mvc.neulibrary.model.rating.Rating;
import param.mvc.neulibrary.model.user.User;
import param.mvc.neulibrary.service.book.BookService;
import param.mvc.neulibrary.service.rating.RatingService;
import param.mvc.neulibrary.service.user.UserService;
import param.mvc.neulibrary.util.CommonAttributesPopulator;

/**
 * Handles requests for the application books's rating page.
 */
@Controller
@RequestMapping(value = "/authors/{author_id}/books/{book_id}")
public class RatingsController {

	@Autowired
	BookService bookService;

	@Autowired
	RatingService ratingService;

	@Autowired
	UserService userService;

	/*
	 * This method will provide the medium to add a new rating.
	 */
	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value = { "/rating" }, method = RequestMethod.GET)
	public String addNewRating(@PathVariable Long book_id, ModelMap model,
			@AuthenticationPrincipal UserDetails userDetails) {
		User currentUser = userService.findByUsername(userDetails.getUsername());
		Book book = bookService.findById(book_id);
		Rating rating = new Rating();

		model.addAttribute("rating", rating);
		model.addAttribute("book", book);

		CommonAttributesPopulator.populate(currentUser, model);

		return "books/rating";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving book's rating in database.
	 */
	@PreAuthorize("hasAuthority('USER')")
	@RequestMapping(value = { "/rating" }, method = RequestMethod.POST)
	public String saveRating(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long book_id,
			@Valid Rating rating, BindingResult result, ModelMap model) {
		User currentUser = userService.findByUsername(userDetails.getUsername());
		Rating ratingToSave = new Rating();

		ratingToSave.setBook(bookService.findById(book_id));
		ratingToSave.setRatingValue(rating.getRatingValue());
		ratingToSave.setUser(currentUser);

		ratingService.saveRating(ratingToSave);

		return "redirect:/authors/{author_id}/books/{book_id}/preview";
	}
}
