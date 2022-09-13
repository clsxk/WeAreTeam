package org.green.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/customLogin")
	public String login() {
		return "login";
	}
	
	@PostMapping(value = "/customLoginFail")
	public String loginFail(@RequestParam String loginFailMessage, Model model) {
		model.addAttribute("loginFailMessage",loginFailMessage);
		return "login";
	}
	@GetMapping (value = "/accessError")
	public String accessError(Authentication auth) {
		log.info("access denied : " + auth);
		return "accessError";
	}
	
}
