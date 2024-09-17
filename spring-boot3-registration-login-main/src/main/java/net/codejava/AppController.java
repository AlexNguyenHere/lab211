package net.codejava;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppController {

	@Autowired
	private UserServices userServices;  
	
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private UserRepository userRepo;

    AppController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, HttpServletRequest request) 
	        throws UnsupportedEncodingException, MessagingException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		
	    String siteURL = request.getRequestURL().toString().replace(request.getServletPath(), "");
	    
	    // Register the user and send verification email
	    userServices.register(user, siteURL);
	    userRepo.save(user);
	    // Return view for successful registration
	    return "register_success";
	}

	
	@GetMapping("/verify")
	public String verifyAccount(@RequestParam("code") String code, Model model) {
		boolean verified = userServices.verify(code);
		
		if (verified) {
			model.addAttribute("message", "Account verified successfully!");
		} else {
			model.addAttribute("message", "Verification failed. Invalid verification code.");
		}
		
		return "verify_result";
	}
	
	
	@GetMapping("/users")
	public String viewUsersList (Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
}
