package tacos.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")

public class OrderController {

	private OrderRepository orderRepo;
	private UserRepository userRepo;

	private OrderProps orderProps;

	@Autowired
	public OrderController(OrderRepository orderRepo, UserRepository userRepo, OrderProps orderProps) {
		this.orderRepo = orderRepo;
		this.userRepo = userRepo;
		this.orderProps = orderProps;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus,
			@AuthenticationPrincipal User user) {// Authentication authentication) {//Principal principal) {
		if (errors.hasErrors())
			return "orderForm";

		/*
		 * Per ottenere l'utente loggato si può anche
		 * 
		 * Authentication authentication =
		 * SecurityContextHolder.getContext().getAuthentication() User user = (User)
		 * authentication.getPrincipal()
		 */

		order.setUser(user);
		orderRepo.save(order);

		sessionStatus.setComplete();

		return "redirect:/";
	}

	/*
	 * @GetMapping public String ordersForUser(@AuthenticationPrincipal User user,
	 * Model model) { Pageable pageable = (Pageable) PageRequest.of(0,
	 * orderProps.getPageSize());
	 * 
	 * model.addAttribute("orders", orderRepo.findByUser(user, pageable));
	 * 
	 * return "orderList"; }
	 */
}
