package willydekeyser.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import willydekeyser.service.AdminService;
import willydekeyser.service.UserService;
import willydekeyser.model.Product;
import willydekeyser.repository.ProductRepository;


@Controller
@AllArgsConstructor

public class HomeController {

	private final UserService userService;
	private final AdminService adminService;
	private ProductRepository productRepository;

	public void ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Привет, мир! Готов к работе!");
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "redirect:/";
	}
	
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("text", userService.getText());
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("text", adminService.getText());
		return "admin";
	}

	@GetMapping("/products")
	public String getProduct(Model model) {
		model.addAttribute("products", productRepository.getProducts());
		return "products";
	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute Product product, Model model) {
		productRepository.addProduct(product);
		model.addAttribute("products", productRepository.getProducts());
		return "products";
	}

}
